package com.example.springtest.services;

import com.example.springtest.dto.UserDto;
import java.util.List;

public interface UsersService {
    List<UserDto> getAllUsers();
}
