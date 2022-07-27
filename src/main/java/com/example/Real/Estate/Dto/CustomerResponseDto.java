package com.example.Real.Estate.Dto;

import com.example.Real.Estate.Model.User;
import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class CustomerResponseDto {
    private Long customerId;
    private String name;
    private String address;
    private String phoneNo;
    private String zanId;
    private String nationality;
    private String employeeStatus;
    private String maritalStatus;
    private String bankName;
    private String bankAccount;
    private String email;
    private String password;
    private String userRole;

}
