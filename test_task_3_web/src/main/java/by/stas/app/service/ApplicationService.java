package by.stas.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {

    private static final String LABEL_TEXT_KEY = "label.text";
    private static final String BUTTON_TEXT_KEY = "button.text";

    private final MessageSource messageSource;

    @Autowired
    public ApplicationService(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String readLabelString() {
        return messageSource.getMessage(LABEL_TEXT_KEY, null, LocaleContextHolder.getLocale());
    }

    public String readButtonString() {
        return messageSource.getMessage(BUTTON_TEXT_KEY, null, LocaleContextHolder.getLocale());
    }
}
