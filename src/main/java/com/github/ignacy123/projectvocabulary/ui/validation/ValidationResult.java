package com.github.ignacy123.projectvocabulary.ui.validation;

/**
 * Created by ignacy on 11.02.16.
 */
public class ValidationResult {
    private boolean valid;
    private String error;

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
