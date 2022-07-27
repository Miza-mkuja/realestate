package com.example.Real.Estate.web.ApiController;


import com.example.Real.Estate.Dto.InvoiceRequestDto;
import com.example.Real.Estate.Dto.InvoiceResponseDto;
import com.example.Real.Estate.Dto.PaymentRequestDto;
import com.example.Real.Estate.Dto.PaymentResponseDto;
import com.example.Real.Estate.Model.Invoice;
import com.example.Real.Estate.Model.Payment;
import com.example.Real.Estate.Service.CustomerServices;
import com.example.Real.Estate.Service.InvoiceServices;
import com.example.Real.Estate.Service.PaymentServices;
import com.example.Real.Estate.web.Api.InvoiceApi;
//import com.example.Real.Estate.web.Api.PaymentApi;
import lombok.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@Data
@Setter
@Getter
@RestController
public class PaymentApiController  {
//    @Autowired
//    private ModelMapper modelMapper;
//    @Autowired
//    PaymentServices paymentServices;
//    @Autowired
//    CustomerServices customerServices;
//    @Autowired
//    InvoiceServices invoiceServices;
//
//
//    @Override
//    public ResponseEntity createPayment(PaymentRequestDto dto) {
//
//        return ResponseEntity.ok().body(paymentServices.addNewPayment(dto));
//    }
//
//    @Override
//    public ResponseEntity updatePayment(Long payment_id, PaymentRequestDto dto) {
//        return ResponseEntity.ok().body(paymentServices.update(payment_id, dto));
//
//    }
//
//    @Override
//    public ResponseEntity<PaymentResponseDto> getPaymentById(Long payment_id) {
//        Optional<Payment> optionalPayment = paymentServices.getPaymentById(payment_id);
//
//        if (!optionalPayment.isPresent()) {
//            throw new IllegalStateException("Payment with Id " + payment_id + "Does Not Exist");
//        }
//        Payment payment = optionalPayment.get();
//        PaymentResponseDto response = new PaymentResponseDto();
//        response.setPaymentId(payment.getPaymentId());
//        response.setPaymentAmount(payment.getPaymentAmount());
//        response.setReceiptNo(payment.getReceiptNo());
//        response.setPaymentReceipt(payment.getPaymentReceipt());
//        response.setPaymentStatus(payment.getPaymentStatus());
//        return ResponseEntity.ok(response);
//    }
//
//    @Override
//    public ResponseEntity<PaymentResponseDto> deletePayment(Long payment_id) {
//        Optional<Payment> optionalPayment = paymentServices.getPaymentById(payment_id);
//
//        if (!optionalPayment.isPresent()) {
//            throw new IllegalStateException("Payment with Id " + payment_id + "Does Not Exist");
//        }
//        paymentServices.deletePayment(payment_id);
//        Payment payment = optionalPayment.get();
//        PaymentResponseDto response = new PaymentResponseDto();
//        response.setPaymentId(payment.getPaymentId());
//        response.setPaymentAmount(payment.getPaymentAmount());
//        response.setReceiptNo(payment.getReceiptNo());
//        response.setPaymentReceipt(payment.getPaymentReceipt());
//        response.setPaymentStatus(payment.getPaymentStatus());
//        return ResponseEntity.ok(response);
//    }
//
//    @Override
//    public ResponseEntity getAllPayment() {
//        return ResponseEntity.ok().body(paymentServices.getPayment());
//    }

}
