package com.huobi.common.util;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.apache.commons.collections.MapUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.huobi.common.exception.HttpRequestException;

import okhttp3.ConnectionPool;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HbdmHttpClient {

	private OkHttpClient httpClient;

	private AtomicInteger numRequestFaild = new AtomicInteger(0);

	static final MediaType JSON_TYPE = MediaType.parse("application/json");

	private HbdmHttpClient() {
		OkHttpClient.Builder builder = new OkHttpClient.Builder()
				.connectionPool(new ConnectionPool(200, 10, TimeUnit.SECONDS)).connectTimeout(3, TimeUnit.SECONDS)
				.readTimeout(5, TimeUnit.SECONDS);
		httpClient = builder.build();
	}

	public static HbdmHttpClient getInstance() {
		return new HbdmHttpClient();
	}

	public String doGet(String url, Map<String, String> params) {
		Request.Builder reqBuild = new Request.Builder();
		HttpUrl.Builder urlBuilder = HttpUrl.parse(url).newBuilder();
		if (MapUtils.isNotEmpty(params)) {
			params.forEach((k, v) -> {
				urlBuilder.addQueryParameter(k, v);
			});
		}
		reqBuild.url(urlBuilder.build());

		Response response = null;
		try {
			response = httpClient.newCall(reqBuild.build()).execute();
		} catch (IOException e) {
			if (e instanceof SocketTimeoutException) {
				numRequestFaild.getAndIncrement();
			}
			throw new HttpRequestException("http执行异常，url=" + url, e);
		}
		if (response.isSuccessful()) {
			try {
				reset();
				return response.body().string();
			} catch (IOException e) {
				throw new HttpRequestException("http结果解析异常", e);
			}
		} else {
			int statusCode = response.code();
			throw new HttpRequestException("响应码不为200，返回响应码：" + statusCode + "，url：" + urlBuilder.build());
		}
	}

	public String doPost(String url, Map<String, String> params) {
		FormBody.Builder builder = new FormBody.Builder();
		if (MapUtils.isNotEmpty(params)) {
			params.forEach((k, v) -> {
				builder.add(k, v);
			});
		}

		Request.Builder reqBuilder = new Request.Builder().url(url);
		if (MapUtils.isNotEmpty(params)) {
			reqBuilder.post(builder.build());
		}

		Response response = null;
		try {
			response = httpClient.newCall(reqBuilder.build()).execute();
		} catch (IOException e) {
			if (e instanceof SocketTimeoutException) {
				numRequestFaild.getAndIncrement();
			}
			throw new HttpRequestException("http执行异常，url=" + url, e);
		}
		if (response.isSuccessful()) {
			try {
				reset();
				return response.body().string();
			} catch (IOException e) {
				throw new HttpRequestException("http结果解析异常", e);
			}
		} else {
			int statusCode = response.code();
			throw new HttpRequestException("响应码不为200，返回响应码：" + statusCode + "，url：" + reqBuilder.build());
		}
	}

	public String doPostJson(String url, Map<String, String> params) {
		RequestBody body = RequestBody.create(JSON_TYPE, JSON.toJSONString(params));
		Request request = new Request.Builder().url(url).post(body).build();
		Response response = null;
		try {
			response = httpClient.newCall(request).execute();
		} catch (IOException e) {
			throw new HttpRequestException("http执行异常，url=" + url, e);
		}
		if (response.isSuccessful()) {
			try {
				return response.body().string();
			} catch (IOException e) {
				throw new HttpRequestException("http结果解析异常", e);
			}
		} else {
			int statusCode = response.code();
			throw new HttpRequestException("响应码不为200，返回响应码：" + statusCode + "，url：" + request);
		}
	}

	public String callJson(String accessKeyId, String accessKeySecret, String method, String uri, String str,
			Map<String, String> params) {

		JSONObject jasonObject = JSONObject.parseObject(str);
		Map map = (Map) jasonObject;
		return call(accessKeyId, accessKeySecret, method, uri, map, params);
	}

	public String call(String accessKeyId, String accessKeySecret, String method, String uri, Object object,
			Map<String, String> params) {
		ApiSignature sign = new ApiSignature();
		sign.createSignature(accessKeyId, accessKeySecret, method, uri, params);
		try {
			Request.Builder builder = null;
			if ("POST".equals(method)) {
				RequestBody body = RequestBody.create(JSON_TYPE, JSON.toJSONString(object));
				builder = new Request.Builder().url(uri + "?" + toQueryString(params)).post(body);
			} else {
				builder = new Request.Builder().url(uri + "?" + toQueryString(params)).get();
			}
			Request request = builder.build();
			Response response = httpClient.newCall(request).execute();
			return response.body().string();
		} catch (IOException e) {
			throw new RuntimeException("IOException 目标url：" + uri, e);
		}
	}

	private String toQueryString(Map<String, String> params) {
		return String.join("&",
				params.entrySet().stream()
						.map((entry) -> entry.getKey() + "=" + ApiSignature.urlEncode(entry.getValue()))
						.collect(Collectors.toList()));
	}

	private void reset() {
		numRequestFaild.set(0);
	}

	public int getRequestFaildTotal() {
		return numRequestFaild.get();
	}
}
