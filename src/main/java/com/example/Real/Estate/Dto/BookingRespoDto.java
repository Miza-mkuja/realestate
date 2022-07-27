package com.example.Real.Estate.Dto;

import com.example.Real.Estate.Model.Customer;
import com.example.Real.Estate.Model.House;
import lombok.Data;

@Data
public class BookingRespoDto {
    private Long bookingId;
    private String bookingRequest;
    private Customer customer;
    private House house;
    private int status;
    private int statusPayment;
    private int receiptNo;
}
