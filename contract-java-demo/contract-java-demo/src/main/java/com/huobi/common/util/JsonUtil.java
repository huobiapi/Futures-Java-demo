package com.huobi.common.util;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonUtil {
	public static String writeValue(Object obj) throws IOException {
		return objectMapper.writeValueAsString(obj);
	}

	public static <T> T readValue(String s, TypeReference<T> ref) throws IOException {
		return objectMapper.readValue(s, ref);
	}

	static final ObjectMapper objectMapper = createObjectMapper();

	static ObjectMapper createObjectMapper() {
		final ObjectMapper mapper = new ObjectMapper();
		mapper.setPropertyNamingStrategy(PropertyNamingStrategy.KEBAB_CASE);
		mapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);
		// disabled features:
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		return mapper;
	}
}
