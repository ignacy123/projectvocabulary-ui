package com.github.ignacy123.projectvocabulary.ui.validation;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by ignacy on 11.02.16.
 */
public class RegistrationValidatorTest {
    private RegistrationValidator registrationValidator;

    @Before
    public void setUp() {
        this.registrationValidator = new RegistrationValidator();
    }

    @Test
    public void testValidateLogin() {
        ValidationResult result = registrationValidator.validateLogin("ed");
        assertThat(result.isValid(), is(false));


    }
}
