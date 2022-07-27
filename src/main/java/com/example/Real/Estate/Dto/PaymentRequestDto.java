package com.example.Real.Estate.Dto;


import lombok.Data;

@Data


public class PaymentRequestDto {
    private String paymentAmount;
    private String receiptNo;
    private String paymentReceipt;
    private String paymentStatus;
    private Long customerId;
    private Long invoiceId;

}
