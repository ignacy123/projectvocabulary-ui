package com.github.ignacy123.projectvocabulary.ui.validation;

/**
 * Created by ignacy on 11.02.16.
 */
public class ValidationResult {
    private boolean valid;

    public ValidationError getError() {
        return error;
    }

    public void setError(ValidationError error) {
        this.error = error;
    }

    private ValidationError error;

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }


    public String getMessage() {
        return error.getMessage();

    }
}
