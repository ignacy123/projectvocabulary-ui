package com.github.ignacy123.projectvocabulary.ui.restapi;

/**
 * Created by ignacy on 14.07.16.
 */
public class RestValidationException extends RuntimeException {
    private ErrorDto errorDto;

    public RestValidationException(ErrorDto errorDto) {

        this.errorDto = errorDto;
    }

    public ErrorDto getErrorDto() {
        return errorDto;
    }
}
