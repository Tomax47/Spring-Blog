package com.example.springtest.controller;

import com.example.springtest.dto.UserForm;
import com.example.springtest.services.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

// The annotation tells Maven that this is a controller
@Controller
public class SignUpController {

    @Autowired
    SignUpService signUpService;

    @GetMapping("/signupPage")
    public String getSignUpPage() {
        return "sign_up_page";
    }

    @PostMapping("/signup")
    public String signUp(UserForm form) {
        // We have to send the data to the service part, then from there to the repo part
        signUpService.addUser(form);
        // Redirecting the user to the sign-up page!
        return "redirect:/signupPage";
    }
}
