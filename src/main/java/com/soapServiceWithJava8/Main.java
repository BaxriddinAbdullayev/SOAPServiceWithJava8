package com.soapServiceWithJava8;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.soapServiceWithJava8.module.AppModule;
import com.soapServiceWithJava8.service.impl.UserServiceImpl;

public class Main {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new AppModule());
        UserServiceImpl userService = injector.getInstance(UserServiceImpl.class);
    }
}
