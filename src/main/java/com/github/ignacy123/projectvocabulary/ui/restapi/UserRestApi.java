package com.github.ignacy123.projectvocabulary.ui.restapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

/**
 * Created by ignacy on 14.07.16.
 */
public class UserRestApi {
    public static final UserRestApi INSTANCE = new UserRestApi();
    private RestTemplate restTemplate;
    private ObjectMapper mapper = new ObjectMapper();

    private UserRestApi() {
        restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
//        restTemplate.setErrorHandler();
    }

    public UserDto register(RegistrationDto registrationDto) {
        try {
            ResponseEntity<UserDto> resultResponseEntity = restTemplate.postForEntity(
                    "http://localhost:8080/projectvocabulary/register",
                    registrationDto,
                    UserDto.class);
            UserDto user = resultResponseEntity.getBody();
            return user;
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

    public UserDto logIn(LogInDto logInDto) {
        try {
            ResponseEntity<UserDto> resultResponseEntity = restTemplate.postForEntity(
                    "http://localhost:8080/projectvocabulary/login",
                    logInDto,
                    UserDto.class);
            List<String> cookies = resultResponseEntity.getHeaders().get("Set-Cookie");
            //JSESSIONID=251A5D5CE98E2F4DE7D017B3853E9361; Path=/projectvocabulary/; HttpOnly
            UserDto user = resultResponseEntity.getBody();
            user.setCookie(cookies.get(0));
            return user;
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
