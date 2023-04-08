package domain.core.message.locale;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;

import javax.validation.MessageInterpolator;
import java.util.Locale;

public class CustomValidationMessageInterpolator implements MessageInterpolator {
    private final MessageInterpolator defaultInterpolator;
    private final ResourceBundleMessageSource messageSource;

    public CustomValidationMessageInterpolator(MessageInterpolator interpolator,
                                               ResourceBundleMessageSource messageSource) {
        this.defaultInterpolator = interpolator;
        this.messageSource = messageSource;
    }

    @Override
    public String interpolate(String messageTemplate, Context context) {
        Locale locale = LocaleContextHolder.getLocale();
        String messageCode = messageTemplate
                .replace("{", "")
                .replace("}", "");
        messageTemplate = messageSource.getMessage(messageCode, null, locale);
        return defaultInterpolator.interpolate(messageTemplate, context);
    }

    @Override
    public String interpolate(String messageTemplate, Context context, Locale locale) {
        String messageCode = messageTemplate
                .replace("{", "")
                .replace("}", "");
        messageTemplate = messageSource.getMessage(messageCode, null, locale);
        return defaultInterpolator.interpolate(messageTemplate, context, locale);
    }
}
