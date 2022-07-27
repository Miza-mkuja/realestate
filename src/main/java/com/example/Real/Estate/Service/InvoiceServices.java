package com.example.Real.Estate.Service;

import com.example.Real.Estate.Dto.*;
import com.example.Real.Estate.Model.Booking;
import com.example.Real.Estate.Model.Customer;
import com.example.Real.Estate.Model.Invoice;
import com.example.Real.Estate.Model.User;
import com.example.Real.Estate.Repository.BookingRepository;
import com.example.Real.Estate.Repository.CustomerRepository;
import com.example.Real.Estate.Repository.InvoiceRepository;
import com.example.Real.Estate.Repository.UserRepository;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Data

public class InvoiceServices {
    @Autowired
    private final InvoiceRepository invoiceRepository;
    private final ModelMapper modelMapper;
    private final CustomerRepository customerRepository;
    private final BookingRepository bookingRepository;


    public List<InvoiceResponseDto> getInvoice() {
        List<Invoice> invoices = invoiceRepository.findAll();
        List list = new ArrayList();
        for (Invoice invoice : invoices) {
            list.add(modelMapper.map(invoice, InvoiceResponseDto.class));
        }
        return list;

    }

    public ResponseEntity addNewInvoice(InvoiceRequestDto dto) {
        Optional<Customer> customerOptional = customerRepository.findById(dto.getCustomerId());
        if (!customerOptional.isPresent()) {
            throw new IllegalStateException("Customer with Id " + dto.getCustomerId() + "Does Not exist");
        }
         Optional<Booking> bookingOptional = bookingRepository.findById(dto.getBookingId());
        if (!bookingOptional.isPresent()) {
           throw new IllegalStateException("Booking with Id " + dto.getBookingId() + "Does Not exist");
        }

        Customer customer = customerOptional.get();
        Booking booking = bookingOptional.get();
        Invoice invoice = new Invoice();
        invoice.setPrice(dto.getPrice());
        invoice.setQuantity(dto.getQuantity());
        invoice.setAmount(dto.getAmount());
        invoice.setDiscription(dto.getDiscription());

        customer.setCustomerId(dto.getCustomerId());
        invoice.setCustomer(customer);
        booking.setBookingId(dto.getBookingId());
        invoice.setBooking(booking);
        invoiceRepository.save(invoice);
        Map map = new HashMap<String, Boolean>();
        map.put("response", Boolean.TRUE);
        return ResponseEntity.ok().body(map);


    }

    public Optional<Invoice> getInvoiceById(Long invoiceId) {
        return invoiceRepository.findById(invoiceId);
    }

    public void deleteInvoice(Long invoiceId) {
        boolean exists = invoiceRepository.existsById(invoiceId);
        if (!exists) {
            throw new IllegalStateException("Invoice with Id " + invoiceId + " does not exist");
        }
        invoiceRepository.deleteById(invoiceId);
    }

    public Object update(Long invoice_id, InvoiceRequestDto dto) {
        Optional<Customer> customerOptional = customerRepository.findById(dto.getCustomerId());
        if (!customerOptional.isPresent()) {
            throw new IllegalStateException("Customer with Id " + dto.getCustomerId() + "Does Not exist");
        }
        Optional<Invoice> invoice1 = invoiceRepository.findById(invoice_id);
        if (!customerOptional.isPresent()) {
            throw new IllegalStateException("User with Id " + invoice_id + "Does Not exist");
        }
        Customer customer = customerOptional.get();
        Invoice invoice = invoice1.get();
        invoice.setPrice(dto.getPrice());
        invoice.setQuantity(dto.getQuantity());
        invoice.setAmount(dto.getAmount());
        invoice.setDiscription(dto.getDiscription());

        customer.setCustomerId(dto.getCustomerId());
        invoice.setCustomer(customer);
        invoiceRepository.save(invoice);
        Map map = new HashMap<String, Boolean>();
        map.put("response", Boolean.TRUE);
        return ResponseEntity.ok().body(map);
    }
}
