package by.stas.app.filter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class LocaleFilter extends OncePerRequestFilter {
    private static final String AVAILABLE_LANGUAGES_REGEX = "(en-US)|(ru-RU)";
    private static final String DEFAULT_LOCALE = "ru-RU";
    private static final String COOKIE_LOCALE_NAME = "lang";
    private static final String LOCALE_PARAMETER = "cookieLocale";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String locale = request.getParameter(LOCALE_PARAMETER);

        Cookie localeCookie;
        if (request.getCookies() == null) {
            localeCookie = new Cookie(COOKIE_LOCALE_NAME, DEFAULT_LOCALE);
        } else {
            localeCookie = Arrays.stream(request.getCookies())
                    .filter(cookie -> cookie.getName().equalsIgnoreCase(COOKIE_LOCALE_NAME))
                    .findFirst().orElse(new Cookie(COOKIE_LOCALE_NAME, DEFAULT_LOCALE));
        }

        if (locale != null && locale.matches(AVAILABLE_LANGUAGES_REGEX)) {
            localeCookie.setValue(locale);
        }
        response.addCookie(localeCookie);
        filterChain.doFilter(request, response);
    }
}
