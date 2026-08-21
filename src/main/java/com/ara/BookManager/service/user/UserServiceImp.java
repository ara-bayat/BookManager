package com.ara.BookManager.service.user;

import com.ara.BookManager.dtos.BookDto;
import com.ara.BookManager.dtos.UserDto;
import com.ara.BookManager.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream()
                .map(UserDto::new).toList();
    }

    @Override
    public UserDto findById(String id) {
        return new UserDto(userRepository.findById(id));
    }

    @Override
    public UserDto findByEmail(String email) {
        return new UserDto(userRepository.findByEmail(email));
    }

    @Override
    public UserDto update(UserDto userDto) {
        return new UserDto(userRepository
                .update(userDto.toUserEntity()));
    }

    @Override
    public long deleteById(String id) {
        return userRepository.delete(id);
    }
}
