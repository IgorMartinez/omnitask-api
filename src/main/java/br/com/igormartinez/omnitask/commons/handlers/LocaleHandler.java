package br.com.igormartinez.omnitask.commons.handlers;

import java.util.List;
import java.util.Locale;

import org.springframework.context.i18n.LocaleContextHolder;

public final class LocaleHandler {

    /**
     * Default locale
     */
    public static final Locale DEFAULT = Locale.ENGLISH;

    /**
     * List of accepted languages
     */
    public static final List<Locale> ACCEPT_LANGUAGES = List.of(
        Locale.ENGLISH,
        Locale.forLanguageTag("pt")
    );

    private LocaleHandler() {}

    /**
     * Get the current locale from the context
     * @return the current locale
     */
    public static final Locale getContext() {
        return LocaleContextHolder.getLocale();
    }
}
