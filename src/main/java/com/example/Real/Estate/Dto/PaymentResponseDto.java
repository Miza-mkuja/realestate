package com.example.Real.Estate.Dto;


import com.example.Real.Estate.Model.Booking;
import com.example.Real.Estate.Model.Customer;
import com.example.Real.Estate.Model.Invoice;
import lombok.*;


@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class PaymentResponseDto {
    private  Long paymentId;
    private String paymentAmount;
    private String receiptNo;
    private String paymentReceipt;
    private String paymentStatus;
    private Customer customer;
    private Invoice invoice;
}
