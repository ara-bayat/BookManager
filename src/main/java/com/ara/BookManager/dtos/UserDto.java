package com.ara.BookManager.dtos;


import com.ara.BookManager.enums.Role;
import com.ara.BookManager.model.SimpleGrantedAuthority;
import com.ara.BookManager.model.UserEntity;
import org.bson.types.ObjectId;

import java.util.List;

public record UserDto(String id, String name, String email, String password,
                      Role role, List<SimpleGrantedAuthority> authorities) {

    public UserDto(UserEntity userEntity) {
        this(userEntity.getId() == null ?
                        new ObjectId().toHexString() :
                        userEntity.getId().toHexString(),
                userEntity.getName(), userEntity.getEmail(), userEntity.getPassword(),
                userEntity.getRole(),
                userEntity.getAuthorities());
    }

    public UserEntity toUserEntity() {
        ObjectId _id = id==null?new ObjectId():new ObjectId(id);

        return new UserEntity(_id, name, email, password, role, authorities);
    }
}
