package com.github.ignacy123.projectvocabulary.ui.validation;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ignacy on 11.02.16.
 */
public class ValidationResult {
    private boolean valid;
    private ValidationError error;
    private Map<String, String> params = new HashMap<>();

    public ValidationError getError() {
        return error;
    }

    public void setError(ValidationError error) {
        this.error = error;
    }


    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }


    public String getMessage() {
        return error.getMessage(params);

    }

    public void addParam(String key, String value) {
        params.put(key, value);
    }
}
