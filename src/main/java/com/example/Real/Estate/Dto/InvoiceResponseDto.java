package com.example.Real.Estate.Dto;


import com.example.Real.Estate.Model.Booking;
import com.example.Real.Estate.Model.Customer;
import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class InvoiceResponseDto {
    private Long invoiceId;
    private Integer price;
    private Integer quantity;
    private Integer amount;
    private String discription;
    private Customer customer;
    private Booking booking;
}
