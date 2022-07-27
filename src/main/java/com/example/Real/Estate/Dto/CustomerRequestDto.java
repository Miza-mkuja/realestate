package com.example.Real.Estate.Dto;

import com.example.Real.Estate.Model.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
public class CustomerRequestDto {
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
