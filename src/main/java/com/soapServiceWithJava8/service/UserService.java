package com.soapServiceWithJava8.service;

import com.soapServiceWithJava8.entity.UserEntity;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface UserService {

    @WebMethod
    UserEntity getUserById(int id);

    @WebMethod
    List<UserEntity> getAllUser();

    @WebMethod
    String cerateUser(UserEntity userEntity);

    @WebMethod
    String updateUser(UserEntity userEntity,int id);

    @WebMethod
    String deleteUser(int id);
}
