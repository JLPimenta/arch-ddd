package domain.shared.validation;

import domain.core.message.Message;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RequiredValidator extends LabelConstraintValidator
        implements ConstraintValidator<Required, Object> {

    private String label;
    private RequiredType type;
    private String defaultMessageCode;

    @Override
    public void initialize(final Required constraintAnnotation) {
        label = constraintAnnotation.label();
        type = constraintAnnotation.type();
        defaultMessageCode = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext context) {
    	context.disableDefaultConstraintViolation();
    	
        if (type != RequiredType.ALL) {
            HttpServletRequest httpServletRequest =
                    ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
            if (type == RequiredType.UPDATE
                    && httpServletRequest.getMethod().equals("POST")) {
                return true;
            }
            if (type == RequiredType.CREATE
                    && httpServletRequest.getMethod().equals("PUT")) {
                return true;
            }
        }

        boolean valid = validate(value);

        var labelValue = Message.toLocale(label);
        
        if (!valid) {
            context.buildConstraintViolationWithTemplate(message(defaultMessageCode).replace("{label}", labelValue))
            	   .addConstraintViolation();
        }
        return valid;
    }

    private boolean validate(final Object value) {
        if (value == null) {
            return false;
        }
        if (value instanceof String stringValue) {
            return !stringValue.trim().isEmpty();
        }
        return true;
    }
}
