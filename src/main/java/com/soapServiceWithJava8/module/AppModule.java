package com.soapServiceWithJava8.module;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.soapServiceWithJava8.factory.DatabaseSessionFactory;
import com.soapServiceWithJava8.service.UserService;
import com.soapServiceWithJava8.service.impl.UserServiceImpl;
import org.apache.ibatis.session.SqlSessionFactory;

public class AppModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(UserService.class).to(UserServiceImpl.class);
    }

    @Provides
    @Singleton
    public SqlSessionFactory provideSqlSessionFactory(DatabaseSessionFactory databaseSessionFactory){
        return databaseSessionFactory.provide();
    }
}
