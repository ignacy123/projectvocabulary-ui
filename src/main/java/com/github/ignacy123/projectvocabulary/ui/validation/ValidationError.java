package com.github.ignacy123.projectvocabulary.ui.validation;

import java.util.Map;

/**
 * Created by ignacy on 18.02.16.
 */
public enum ValidationError {
    VALIDATION_NO_SPACES("Name shouldn't contain spaces."),
    VALIDATION_MIN_LENGTH("Value should be longer than :minLength characters."),
    VALIDATION_MAX_LENGTH("Value should be shorter than :maxLength characters."),
    VALIDATION_EMAIL_INVALID("Email is not valid.");


    private final String messageTemplate;

    ValidationError(String message) {
        this.messageTemplate = message;
    }

    public String getMessage(Map<String, String> params) {
        String message = messageTemplate;
        for (Map.Entry<String, String> entry : params.entrySet()) {
            message = message.replaceAll(":" + entry.getKey(), entry.getValue());
        }
        return message;
    }

    public String getMessage() {
        return messageTemplate;
    }
}
