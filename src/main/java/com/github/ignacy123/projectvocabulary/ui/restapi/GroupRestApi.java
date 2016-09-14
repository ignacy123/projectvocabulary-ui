package com.github.ignacy123.projectvocabulary.ui.restapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.ignacy123.projectvocabulary.ui.domain.Group;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * Created by ignacy on 13.09.16.
 */
public class GroupRestApi extends AbstractRestApi {
    public static final GroupRestApi INSTANCE = new GroupRestApi();

    private GroupRestApi() {
        super();
    }

    public Group create(GroupDto groupDto) {
        return post("/groups", groupDto, Group.class).getBody();
    }
}
