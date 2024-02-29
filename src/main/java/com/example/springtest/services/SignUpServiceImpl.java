package com.example.springtest.services;

import com.example.springtest.dto.UserForm;
import com.example.springtest.model.User;
import com.example.springtest.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // This class is responsible for business logic
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private UserRepo userRepo; // We use the @AutoWired to do the initialization part for the class "userRepo = new UserRepoImpl etc..,"

    @Override
    public void addUser(UserForm form) {
        User user = User.builder()
                .email(form.getEmail())
                .password(form.getPassword())
                .build();

        userRepo.save(user);
    }
}
