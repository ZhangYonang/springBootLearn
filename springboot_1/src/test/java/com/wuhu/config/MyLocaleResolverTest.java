package com.wuhu.config;

import org.junit.jupiter.api.Test;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;


public class MyLocaleResolverTest {
    @Test
    public void resolveLocale() {
        MyLocaleResolver myLocaleResolver = new MyLocaleResolver();
        HttpServletRequest request = null;
        Locale locale = myLocaleResolver.resolveLocale(request);
    }
}