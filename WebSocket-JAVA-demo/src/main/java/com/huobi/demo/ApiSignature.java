package com.huobi.demo;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class ApiSignature {
	public static String op = "op";
	public static String opValue = "auth";
	public static String accessKeyId = "AccessKeyId";
	public static String signatureMethod = "SignatureMethod";
	public static String signatureMethodValue = "HmacSHA256";
	public static String signatureVersion = "SignatureVersion";
	public static String signatureVersionValue = "2";
	public static String timestamp = "Timestamp";
	public static String signature = "Signature";
	/**
	 * API 签名， 签名标准：
	 * <p>
	 * http://docs.aws.amazon.com/zh_cn/general/latest/gr/signature-version-2.html
	 */

	static final DateTimeFormatter DT_FORMAT = DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm:ss");
	static final ZoneId ZONE_GMT = ZoneId.of("Z");

	/**
	 * 添加参数AccessKeyId、时间戳、SignatureVersion、SignatureMethod、Signature。
	 *
	 * @param accessKey
	 *            AppKeyId.
	 * @param secretKey
	 *            AppKeySecret.
	 * @param method
	 *            请求方法 ，"GET" or "POST"
	 * @param host
	 *            请求地址，example "be.huobi.com"
	 * @param uri
	 *            请求路径 path ，example "/v1/api/info"
	 * @param params
	 *            the original parameters， save as Key-Value ，Don't encode Value
	 */
	public void createSignature(String accessKey, String secretKey, String method, String host, String uri,
			Map<String, String> params) {
		StringBuilder sb = new StringBuilder(1024);

		// 1 请求方法 (GET or POST) 在后边加上`\n`.
		sb.append(method.toUpperCase()).append('\n')
				// 2. 小写的host 在后边加上 `\n`.
				.append(host.toLowerCase()).append('\n')
				// 3. 请求路径, 在后边加上 `\n`.
				.append(uri).append('\n');

		// 4.将签名按ASCII 排名
		params.remove(signature);
		params.put(accessKeyId, accessKey);
		params.put(signatureVersion, signatureVersionValue);
		params.put(signatureMethod, signatureMethodValue);
		params.put(timestamp, gmtNow());

		// 按照上面的顺序，将每个参数与字符“&”连接。
		SortedMap<String, String> map = new TreeMap<>(params);
		for (Map.Entry<String, String> entry : map.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			sb.append(key).append('=').append(urlEncode(value)).append('&');
		}
		// 删除最后的 `&`
		sb.deleteCharAt(sb.length() - 1);
		// 签名:
		Mac hmacSha256 = null;
		try {
			hmacSha256 = Mac.getInstance(signatureMethodValue);
			SecretKeySpec secKey = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), signatureMethodValue);
			hmacSha256.init(secKey);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("No such algorithm: " + e.getMessage());
		} catch (InvalidKeyException e) {
			throw new RuntimeException("Invalid key: " + e.getMessage());
		}
		String payload = sb.toString();
		byte[] hash = hmacSha256.doFinal(payload.getBytes(StandardCharsets.UTF_8));

		// 获取签名，并进行Base64编码
		String actualSign = Base64.getEncoder().encodeToString(hash);

		// 将签名放入params
		params.put(signature, actualSign);

	}

	/**
	 * 使用标准的URL编码。+。
	 *
	 * @param s
	 *            string
	 * @return 编码结果
	 */
	public static String urlEncode(String s) {
		try {
			return URLEncoder.encode(s, "UTF-8").replaceAll("\\+", "%20");
		} catch (UnsupportedEncodingException e) {
			throw new IllegalArgumentException("UTF-8 encoding not supported!");
		}
	}

	/**
	 * 返回秒数
	 */
	long epochNow() {
		return Instant.now().getEpochSecond();
	}

	String gmtNow() {
		return Instant.ofEpochSecond(epochNow()).atZone(ZONE_GMT).format(DT_FORMAT);
	}

}
