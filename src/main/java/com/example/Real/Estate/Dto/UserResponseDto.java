package com.example.Real.Estate.Dto;

import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class UserResponseDto {
    private  Long userId;
    private String username;
    private String email;
    private String userRole;
}
