package com.ara.BookManager.repository.user;


import com.ara.BookManager.model.UserEntity;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {
    UserEntity save(UserEntity user);
    List<UserEntity> findAll();
    UserEntity findById(String id);
    UserEntity findByEmail(String email);
    UserEntity update(UserEntity user);
    long delete(String id);
}
