package com.example.springtest.dto;


import lombok.*;
@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserForm {

    private String email;
    private String password;
}
