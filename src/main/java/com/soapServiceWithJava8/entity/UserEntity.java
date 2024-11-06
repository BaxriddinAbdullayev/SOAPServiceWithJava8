package com.soapServiceWithJava8.entity;

import lombok.Data;

@Data
public class UserEntity {

    private Integer id;
    private String username;
    private String password;
    private String roles_id;

}
