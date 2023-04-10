package com.biblioteca.domain.shared.validation;



import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = RequiredValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Required {
    String label() default "";

    String message() default "{validation.required}";

    RequiredType type() default RequiredType.ALL;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
