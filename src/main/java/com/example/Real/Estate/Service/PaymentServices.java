package com.example.Real.Estate.Service;

import com.example.Real.Estate.Dto.InvoiceRequestDto;
import com.example.Real.Estate.Dto.InvoiceResponseDto;
import com.example.Real.Estate.Dto.PaymentRequestDto;
import com.example.Real.Estate.Dto.PaymentResponseDto;
import com.example.Real.Estate.Model.Booking;
import com.example.Real.Estate.Model.Customer;
import com.example.Real.Estate.Model.Invoice;
import com.example.Real.Estate.Model.Payment;
import com.example.Real.Estate.Repository.BookingRepository;
import com.example.Real.Estate.Repository.CustomerRepository;
import com.example.Real.Estate.Repository.InvoiceRepository;
import com.example.Real.Estate.Repository.PaymentRepository;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Data

public class PaymentServices {


    private final PaymentRepository paymentRepository;
    private final ModelMapper modelMapper;
    private final CustomerRepository customerRepository;
    private final InvoiceRepository invoiceRepository;

    @Autowired
    public List<PaymentResponseDto> getPayment() {
        List<Payment> payments = paymentRepository.findAll();
        List list = new ArrayList();
        for (Payment payment : payments) {
            list.add(modelMapper.map(payment, PaymentResponseDto.class));
        }
        return list;
    }


    public ResponseEntity addNewPayment(PaymentRequestDto dto) {
        Optional<Customer> customerOptional = customerRepository.findById(dto.getCustomerId());
        if (!customerOptional.isPresent()) {
            throw new IllegalStateException("Customer with Id " + dto.getCustomerId() + "Does Not exist");
        }
        Optional<Invoice> invoiceOptional = invoiceRepository.findById(dto.getInvoiceId());
        if (!invoiceOptional.isPresent()) {
            throw new IllegalStateException("Invoice with Id " + dto.getInvoiceId() + "Does Not exist");
        }

        Customer customer = customerOptional.get();
        Invoice invoice = invoiceOptional.get();
        Payment payment = new Payment();
        payment.setPaymentAmount(dto.getPaymentAmount());
        payment.setReceiptNo(dto.getReceiptNo());
        payment.setPaymentReceipt(dto.getPaymentReceipt());
        payment.setPaymentStatus(dto.getPaymentStatus());

        customer.setCustomerId(dto.getCustomerId());
        payment.setCustomer(customer);
        invoice.setInvoiceId(dto.getInvoiceId());
        payment.setInvoice(invoice);
        paymentRepository.save(payment);
        Map map = new HashMap<String, Boolean>();
        map.put("response", Boolean.TRUE);
        return ResponseEntity.ok().body(map);
    }


    public Optional<Payment> getPaymentById(Long paymentId) {
        return paymentRepository.findById(paymentId);
    }

    public void deletePayment(Long paymentId) {
        boolean exists = paymentRepository.existsById(paymentId);
        if (!exists) {
            throw new IllegalStateException("Payment with Id " + paymentId + " does not exist");
        }
        paymentRepository.deleteById(paymentId);
    }


    public Object update(Long payment_id, PaymentRequestDto dto) {
        Optional<Customer> customerOptional = customerRepository.findById(dto.getCustomerId());
        if (!customerOptional.isPresent()) {
            throw new IllegalStateException("Customer with Id " + dto.getCustomerId() + "Does Not exist");
        }
        Optional<Payment> payment1 = paymentRepository.findById(payment_id);
        if (!customerOptional.isPresent()) {
            throw new IllegalStateException("Customer with Id " + payment_id + "Does Not exist");
        }
        Customer customer = customerOptional.get();
        Payment payment = payment1.get();
        payment.setPaymentAmount(dto.getPaymentAmount());
        payment.setReceiptNo(dto.getReceiptNo());
        payment.setPaymentReceipt(dto.getPaymentReceipt());
        payment.setPaymentStatus(dto.getPaymentStatus());

        customer.setCustomerId(dto.getCustomerId());
        payment.setCustomer(customer);
        paymentRepository.save(payment);
        Map map = new HashMap<String, Boolean>();
        map.put("response", Boolean.TRUE);
        return ResponseEntity.ok().body(map);
    }
}
