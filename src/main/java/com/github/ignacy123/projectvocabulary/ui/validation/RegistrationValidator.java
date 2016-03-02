package com.github.ignacy123.projectvocabulary.ui.validation;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ignacy on 11.02.16.
 */

public class RegistrationValidator  {
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private Pattern pattern;
    private Matcher matcher;

    public ValidationResult validateLogin(String login) {
        ValidationResult validationResult = new ValidationResult();
        if (!login.trim().equals(login)) {
            validationResult.setValid(false);
            validationResult.setError(ValidationError.VALIDATION_NO_SPACES);
            return validationResult;
        }
        if (login.length() <= 3) {
            validationResult.setValid(false);
            validationResult.setError(ValidationError.VALIDATION_MIN_LENGTH);
            validationResult.addParam("minLength", "3");
            return validationResult;
        }
        if (login.length() >= 15) {
            validationResult.setValid(false);
            validationResult.setError(ValidationError.VALIDATION_MAX_LENGTH);
            return validationResult;
        }
        validationResult.setValid(true);
        return validationResult;
    }

    public ValidationResult validateEmail(String email) {
        ValidationResult validationResult = new ValidationResult();
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        if (matcher.matches()) {
            validationResult.setValid(true);
            return validationResult;
        }
        validationResult.setError(ValidationError.VALIDATION_EMAIL_INVALID);
        validationResult.setValid(false);
        return validationResult;
    }

    public ValidationResult validatePassword(String password) {
        ValidationResult validationResult = new ValidationResult();
        if (!password.trim().equals(password)) {
            validationResult.setValid(false);
            validationResult.setError(ValidationError.VALIDATION_NO_SPACES);
            return validationResult;
        }
        if (password.length() <= 6) {
            validationResult.setValid(false);
            validationResult.setError(ValidationError.VALIDATION_MIN_LENGTH);
            return validationResult;
        }
        if (password.length() >= 15) {
            validationResult.setValid(false);
            validationResult.setError(ValidationError.VALIDATION_MAX_LENGTH);
            return validationResult;
        }
        validationResult.setValid(true);
        return validationResult;
    }
}


