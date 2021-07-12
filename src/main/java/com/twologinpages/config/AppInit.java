package com.twologinpages.config;

import org.jetbrains.annotations.NotNull;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.ServletRegistration;


public final class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {


    @Override
    protected final Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{ RootConfig.class };
    }

    @Override
    protected final Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { Config.class };
    }

    @NotNull
    @Override
    protected final String[] getServletMappings() {
        return new String[]{"/"};
    }


    @Override
    public void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");
    }


    @Override
    protected final Filter[] getServletFilters(){
        // Создание фильтра кодировки, который позволит работать с русскими символами.
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        // Создание фильтра, который добавляет поддержку HTTP методов (например, таких как PUT).
        HiddenHttpMethodFilter httpMethodFilter = new HiddenHttpMethodFilter();
        return new Filter[]{characterEncodingFilter, httpMethodFilter};
    }
}
