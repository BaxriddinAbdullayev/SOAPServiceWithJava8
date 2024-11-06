package com.soapServiceWithJava8.config;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.soapServiceWithJava8.module.AppModule;

public class GuiceConfig extends GuiceServletContextListener {

    // Parametrsiz public konstruktor
    public GuiceConfig() {
        super();
    }

    @Override
    protected Injector getInjector() {
        return Guice.createInjector(new AppModule());
    }
}
