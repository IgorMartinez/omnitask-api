package br.com.igormartinez.omnitask.commons.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import br.com.igormartinez.omnitask.commons.handlers.LocaleHandler;

@Configuration
public class LocaleConfig {

    @Bean
    LocaleResolver localeResolver() {
        AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
        localeResolver.setDefaultLocale(Locale.ENGLISH);
        localeResolver.setSupportedLocales(LocaleHandler.ACCEPT_LANGUAGES);
        return localeResolver;
    }
} 