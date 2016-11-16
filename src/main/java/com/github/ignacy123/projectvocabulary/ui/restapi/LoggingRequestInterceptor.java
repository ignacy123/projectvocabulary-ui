package com.github.ignacy123.projectvocabulary.ui.restapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;

public class LoggingRequestInterceptor implements ClientHttpRequestInterceptor {

	final static Logger LOGGER = LoggerFactory.getLogger(LoggingRequestInterceptor.class);

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
		traceRequest(request, body);

		ClientHttpResponse response = execution.execute(request, body);
		BufferingClientHttpResponseWrapper responseWrapper = new BufferingClientHttpResponseWrapper(response);
		traceResponse(responseWrapper);
		return responseWrapper;
	}

	private void traceRequest(HttpRequest request, byte[] body) throws IOException {
		LOGGER.debug("============================request begin===========================================");
		LOGGER.debug("URI         : {}", request.getURI());
		LOGGER.debug("Method      : {}", request.getMethod());
		LOGGER.debug("Headers     : {}", request.getHeaders());
		LOGGER.debug("Request body: {}", new String(body, "UTF-8"));
		LOGGER.debug("============================request end=============================================");
	}

	private void traceResponse(ClientHttpResponse response) throws IOException {

		byte[] responseBytes;
		try {
			responseBytes = StreamUtils.copyToByteArray(response.getBody());
		}catch(IOException e){
			LOGGER.error("couldnt intercept request", e);
			return;
		}

		LOGGER.debug("============================response begin==========================================");
		LOGGER.debug("Status text  : {}", response.getStatusText());
		LOGGER.debug("Headers      : {}", response.getHeaders());
		LOGGER.debug("Response body: {}", new String(responseBytes, "UTF-8"));
		LOGGER.debug("============================response end============================================");
	}

}