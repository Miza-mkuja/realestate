package com.example.Real.Estate.web.Api;

import com.example.Real.Estate.Dto.InvoiceRequestDto;
import com.example.Real.Estate.Dto.InvoiceResponseDto;
import com.example.Real.Estate.Dto.PaymentRequestDto;
import com.example.Real.Estate.Dto.PaymentResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RequestMapping("api/payment")


public interface PaymentApi {
    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity<PaymentResponseDto> createPayment(@RequestBody PaymentRequestDto dto);

    @RequestMapping(value = "/{payment_id}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public ResponseEntity<PaymentResponseDto> updatePayment(@PathVariable Long payment_id, @RequestBody PaymentRequestDto dto);

    @RequestMapping(value = "/{payment_id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<PaymentResponseDto> getPaymentById(@PathVariable Long payment_id);

    @RequestMapping(value = "/{payment_id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<PaymentResponseDto> deletePayment(@PathVariable Long payment_id);

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Map<String, Object>> getAllPayment();

}
