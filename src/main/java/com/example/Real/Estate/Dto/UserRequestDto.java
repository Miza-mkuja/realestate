package com.example.Real.Estate.Dto;

import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class UserRequestDto {
    private String username;
    private String email;
    private String password;
    private String userRole;
}
