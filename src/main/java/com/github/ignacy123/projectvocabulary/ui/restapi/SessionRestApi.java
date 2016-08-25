package com.github.ignacy123.projectvocabulary.ui.restapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.ignacy123.projectvocabulary.ui.domain.SessionWord;
import com.github.ignacy123.projectvocabulary.ui.domain.User;
import com.github.ignacy123.projectvocabulary.ui.dto.SessionRequest;
import com.github.ignacy123.projectvocabulary.ui.dto.SessionWordDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

/**
 * Created by ignacy on 20.07.16.
 */
public class SessionRestApi {
    public static final SessionRestApi INSTANCE = new SessionRestApi();
    private RestTemplate restTemplate;
    private ObjectMapper mapper = new ObjectMapper();

    public SessionRestApi() {
        restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
//        restTemplate.setErrorHandler();
    }


    public void prepareWord(User user, List<SessionWord> sessionWords, int amount) {

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        SessionRequest sessionRequest = new SessionRequest();
        sessionRequest.setSize(amount);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie", user.getCookie());
        HttpEntity<SessionRequest> httpEntity = new HttpEntity<>(sessionRequest, headers);
        ResponseEntity<SessionWordDto[]> resultResponseEntity = restTemplate.postForEntity(
                "http://localhost:8080/projectvocabulary/dictionary/session",
                httpEntity,
                SessionWordDto[].class);
        SessionWordDto[] body = resultResponseEntity.getBody();
        sessionWords.addAll(SessionWordDto.convertToSessionWords(body));
    }
}
