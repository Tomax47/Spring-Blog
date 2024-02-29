package com.example.springtest.dto;

import com.example.springtest.model.User;
import lombok.*;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private long id;
    private String email;

    private static UserDto from(User user) {
        return UserDto.builder().id(user.getId()).email(user.getEmail()).build();
    }

    public static List<UserDto> userList(List<User> users) {
        return users.stream()
                .map(UserDto::from)
                .collect(Collectors.toList());
    }
}
