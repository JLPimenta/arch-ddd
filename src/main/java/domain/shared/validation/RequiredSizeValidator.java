package domain.shared.validation;

import domain.core.message.Message;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;


import java.util.Collection;
import java.util.Objects;

public class RequiredSizeValidator extends LabelConstraintValidator
        implements ConstraintValidator<RequiredSize, Object> {

    private static final String VALIDATION_REQUIRED = "{validation.required}";
    private static final String LABEL_PARAMETER = "{label}";

    private int min;
    private int max;
    private String label;
    private boolean required;

    @Override
    public void initialize(final RequiredSize constraintAnnotation) {
        min = constraintAnnotation.min();
        max = constraintAnnotation.max();
        label = constraintAnnotation.label();
        required = constraintAnnotation.required();
    }

    @SuppressWarnings("rawtypes")
    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext context) {

        context.disableDefaultConstraintViolation();

        var labelValue = Message.toLocale(label);

        if (Objects.isNull(value) && required) {
            context.buildConstraintViolationWithTemplate(
                    message(VALIDATION_REQUIRED).replace(LABEL_PARAMETER, labelValue)).addConstraintViolation();

            return false;
        }

        if (Objects.nonNull(value) && Collection.class.isAssignableFrom(value.getClass())) {
            var collectionValue = (Collection) value;

            if (collectionValue.isEmpty() && required) {
                context.buildConstraintViolationWithTemplate(
                        message(VALIDATION_REQUIRED).replace(LABEL_PARAMETER, labelValue)).addConstraintViolation();

                return false;
            }

            return isValid(context, collectionValue.size(), labelValue, "validation.collection");
        }

        if (value instanceof String valueString) {
            if (required && StringUtils.isBlank(valueString.trim())) {
                context.buildConstraintViolationWithTemplate(message(VALIDATION_REQUIRED)
                                .replace(LABEL_PARAMETER, labelValue))
                        .addConstraintViolation();
                return false;
            }

            return isValid(context, valueString.length(), labelValue, "validation");
        }

        return true;
    }

    private boolean isValid(final ConstraintValidatorContext context, final int value,
                            final String labelValue, final String validationMessageBase) {
        if (min > 0 && max > 0 &&
                (value < min || value > max)) {
            context.buildConstraintViolationWithTemplate(message(String.format("{%s.size}", validationMessageBase))
                            .replace(LABEL_PARAMETER, labelValue)
                            .replace("{min}", String.valueOf(min))
                            .replace("{max}", String.valueOf(max)))
                    .addConstraintViolation();

            return false;
        } else if (min > 0 && max <= 0
                && value < min) {
            context.buildConstraintViolationWithTemplate(message(String.format("{%s.size.min}", validationMessageBase))
                            .replace(LABEL_PARAMETER, labelValue)
                            .replace("{min}", String.valueOf(min)))
                    .addConstraintViolation();
            return false;
        } else if (max > 0 && min <= 0
                && value > max) {
            context.buildConstraintViolationWithTemplate(message(String.format("{%s.size.max}", validationMessageBase))
                            .replace(LABEL_PARAMETER, labelValue)
                            .replace("{max}", String.valueOf(max)))
                    .addConstraintViolation();
            return false;
        }

        return true;
    }

}
