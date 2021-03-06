package com.github.ignacy123.projectvocabulary.ui.restapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.ignacy123.projectvocabulary.ui.dto.UserUpdateDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.StreamUtils;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * Created by ignacy on 14.09.16.
 */
public abstract class AbstractRestApi {
	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractRestApi.class);
	protected final RestTemplate restTemplate;
	protected final ObjectMapper mapper;

	protected AbstractRestApi() {
		restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		restTemplate.getInterceptors().add(new LoggingRequestInterceptor());
        restTemplate.setErrorHandler(new DefaultResponseErrorHandler(){

			@Override
            public void handleError(ClientHttpResponse response) throws IOException {
				byte[] responseBytes = StreamUtils.copyToByteArray(response.getBody());

				LOGGER.debug("============================error response begin==========================================");
				LOGGER.debug("Status text  : {}", response.getStatusText());
				LOGGER.debug("Headers      : {}", response.getHeaders());
				LOGGER.debug("Response body: {}", new String(responseBytes, "UTF-8"));
				LOGGER.debug("============================error response end============================================");
                super.handleError(response);
            }
        });
		mapper = new ObjectMapper();
	}

	protected <T> ResponseEntity<T> post(String url, Object object, Class<T> returnClass) {
		try {
			ResponseEntity<T> resultResponseEntity = restTemplate.postForEntity(
					"http://localhost:8080/projectvocabulary" + url,
					object,
					returnClass);
			return resultResponseEntity;
		} catch (HttpClientErrorException e) {
			String errorJson = e.getResponseBodyAsString();
			try {
				ErrorDto errorDto = mapper.readValue(errorJson, ErrorDto.class);
				throw new RestValidationException(errorDto);
			} catch (IOException e1) {
				throw new RuntimeException(e1);
			}
		}

	}

	protected <T> ResponseEntity<T> postWithCookie(String url, Object object, Class<T> returnClass, String cookie) {
		return sendWithCookie(HttpMethod.POST, url, object, returnClass, cookie);

	}

	protected <T> ResponseEntity<T> putWithCookie(String url, Object object, Class<T> returnClass, String cookie) {
		return sendWithCookie(HttpMethod.PUT, url, object, returnClass, cookie);
	}

	private <T> ResponseEntity<T> sendWithCookie(HttpMethod method, String url, Object object, Class<T> returnClass, String cookie) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.add("Cookie", cookie);
			HttpEntity<Object> httpEntity = new HttpEntity<>(object, headers);
			ResponseEntity<T> responseEntity = restTemplate.exchange("http://localhost:8080/projectvocabulary" + url, method, httpEntity, returnClass);
			return responseEntity;
		} catch (HttpClientErrorException e) {
			String errorJson = e.getResponseBodyAsString();
			try {
				ErrorDto errorDto = mapper.readValue(errorJson, ErrorDto.class);
				throw new RestValidationException(errorDto);
			} catch (IOException e1) {
				throw new RuntimeException(e1);
			}
		}

	}

	protected <T> ResponseEntity<T> getWithCookie(String url, Class<T> returnClass, String cookie) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.add("Cookie", cookie);
			HttpEntity<Object> httpEntity = new HttpEntity<>(headers);
			ResponseEntity<T> responseEntity = restTemplate.exchange("http://localhost:8080/projectvocabulary" + url, HttpMethod.GET, httpEntity, returnClass);
			return responseEntity;
		} catch (HttpClientErrorException e) {
			String errorJson = e.getResponseBodyAsString();
			try {
				ErrorDto errorDto = mapper.readValue(errorJson, ErrorDto.class);
				throw new RestValidationException(errorDto);
			} catch (IOException e1) {
				throw new RuntimeException(e1);
			}
		}

	}

}
