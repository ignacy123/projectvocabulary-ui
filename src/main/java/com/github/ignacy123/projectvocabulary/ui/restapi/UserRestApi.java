package com.github.ignacy123.projectvocabulary.ui.restapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.ignacy123.projectvocabulary.ui.domain.User;
import com.github.ignacy123.projectvocabulary.ui.dto.SessionRequest;
import com.github.ignacy123.projectvocabulary.ui.dto.SessionWordDto;
import com.github.ignacy123.projectvocabulary.ui.dto.UserUpdateDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

/**
 * Created by ignacy on 14.07.16.
 */
public class UserRestApi extends AbstractRestApi {
    public static final UserRestApi INSTANCE = new UserRestApi();

    private UserRestApi() {
        super();
    }

    public UserDto register(RegistrationDto registrationDto) {
        return post("/register", registrationDto, UserDto.class).getBody();

    }

    public UserDto logIn(LogInDto logInDto) {
        ResponseEntity<UserDto> post = post("/login", logInDto, UserDto.class);
        List<String> cookies = post.getHeaders().get("Set-Cookie");
        UserDto user = post.getBody();
        user.setCookie(cookies.get(0));
        return user;
    }

    public UserDto update(UserUpdateDto userUpdateDto, User currentUser) {
        String url = String.format("http://localhost:8080/projectvocabulary/users/%d", currentUser.getId());
        return putWithCookie(url, userUpdateDto, UserDto.class, currentUser.getCookie()).getBody();
    }

}


