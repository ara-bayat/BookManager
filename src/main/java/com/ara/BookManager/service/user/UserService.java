package com.ara.BookManager.service.user;

import com.ara.BookManager.dtos.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();
    UserDto findById(String id);
    UserDto findByEmail(String email);
    UserDto update(UserDto userDto);
    long deleteById(String id);
}
