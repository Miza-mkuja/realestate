package com.example.Real.Estate.Model;

import com.example.Real.Estate.Model.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;


@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity
public class Customer {
    @Id
    @Column(name = "customer_id")
    @SequenceGenerator(
            name = "customer_sequence",
            sequenceName = "customer_sequence",
            allocationSize = 1

    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_sequence"
    )
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







