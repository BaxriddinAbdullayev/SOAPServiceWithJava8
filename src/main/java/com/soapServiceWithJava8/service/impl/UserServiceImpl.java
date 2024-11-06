package com.soapServiceWithJava8.service.impl;

import com.google.inject.Inject;
import com.soapServiceWithJava8.entity.UserEntity;
import com.soapServiceWithJava8.factory.DatabaseSessionFactory;
import com.soapServiceWithJava8.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.inject.Singleton;
import javax.jws.WebService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebService
@Singleton
public class UserServiceImpl implements UserService {

    private final SqlSessionFactory db;

    @Inject
    public UserServiceImpl(SqlSessionFactory sqlSessionFactory) {
        DatabaseSessionFactory factory=new DatabaseSessionFactory();
        this.db = factory.provide();
    }

    public UserServiceImpl() {
        DatabaseSessionFactory factory=new DatabaseSessionFactory();
        this.db=factory.provide();
    }


    @Override
    public UserEntity getUserById(int id) {
        try (SqlSession sqlSession = db.openSession(true)) {
            Map<String, Object> params = new HashMap<>();
            params.put("id", id);
            return sqlSession.selectOne("getUser", params);
        }
    }

    @Override
    public List<UserEntity> getAllUser() {
        try (SqlSession sqlSession = db.openSession(true)) {
            return sqlSession.selectList("getUser");
        }
    }

    @Override
    public String cerateUser(UserEntity userEntity) {
        try (SqlSession sqlSession = db.openSession(true)) {
            int insertUser = sqlSession.insert("insertUser", userEntity);
        }
        return "User muvaffaqqiyatli qo'shildi";
    }

    @Override
    public String updateUser(UserEntity userEntity, int id) {
        try (SqlSession sqlSession = db.openSession(true)) {
            Map<String, Object> params = new HashMap<>();
            params.put("id", id);
            params.put("username", userEntity.getUsername());
            params.put("password", userEntity.getPassword());
            params.put("roles_id", userEntity.getRoles_id());
            int updateUser = sqlSession.update("updateUser", params);
        }
        return "User muvaffaqqiyatli o'zgartirildi";
    }

    @Override
    public String deleteUser(int id) {
        try (SqlSession sqlSession = db.openSession(true)){
            Map<String, Object> params = new HashMap<>();
            params.put("id", id);
            int deleteUser = sqlSession.delete("deleteUser", params);
        }
        return "User muvaffaqqiyatli o'chirildi";
    }
}
