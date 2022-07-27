package com.example.Real.Estate.Dto;


import lombok.Data;

@Data

public class InvoiceRequestDto {
    private Integer price;
    private Integer quantity;
    private Integer amount;
    private String discription;
    private Long customerId;
    private Long bookingId;
}
