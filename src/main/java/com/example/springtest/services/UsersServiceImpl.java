package com.example.springtest.services;

import com.example.springtest.dto.UserDto;
import com.example.springtest.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import static com.example.springtest.dto.UserDto.userList;

@Component
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public List<UserDto> getAllUsers() {
        return userList(userRepo.findAll());
    }
}
