package com.socmour.springsecurity.demo.config.Validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator implements ConstraintValidator<ValidEmail, String> {
    private Pattern pattern;
    private Matcher matcher;
    private static final String EMAIL_PATTERN =
            "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,}$";
    @Override
    public boolean isValid(final String email, final ConstraintValidatorContext
            context) {
        pattern = Pattern.compile(EMAIL_PATTERN);
        if (email == null) {
            return false;
        }
        matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
