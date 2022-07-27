package com.example.Real.Estate.web.ApiController;


import com.example.Real.Estate.Dto.InvoiceRequestDto;
import com.example.Real.Estate.Dto.InvoiceResponseDto;
import com.example.Real.Estate.Model.Invoice;
import com.example.Real.Estate.Service.BookingService2;
import com.example.Real.Estate.Service.CustomerServices;
import com.example.Real.Estate.Service.InvoiceServices;
import com.example.Real.Estate.web.Api.InvoiceApi;
import lombok.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@RestController

public class InvoiceApiController implements InvoiceApi {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    InvoiceServices invoiceServices;
    @Autowired
    CustomerServices customerServices;
    @Autowired
    BookingService2 bookingServices;


    @Override
    public ResponseEntity createInvoice(InvoiceRequestDto dto) {

        return ResponseEntity.ok().body(invoiceServices.addNewInvoice(dto));
    }

    @Override
    public ResponseEntity updateInvoice(Long invoice_id, InvoiceRequestDto dto) {
        return ResponseEntity.ok().body(invoiceServices.update(invoice_id, dto));
    }

    @Override
    public ResponseEntity<InvoiceResponseDto> getInvoiceById(Long invoice_id) {
        Optional<Invoice> optionalInvoice = invoiceServices.getInvoiceById(invoice_id);

        if (!optionalInvoice.isPresent()) {
            throw new IllegalStateException("Invoice with Id " + invoice_id + "Does Not Exist");
        }
        Invoice invoice = optionalInvoice.get();
        InvoiceResponseDto response = new InvoiceResponseDto();
        response.setInvoiceId(invoice.getInvoiceId());
        response.setPrice(invoice.getPrice());
        response.setQuantity(invoice.getQuantity());
        response.setAmount(invoice.getAmount());
        response.setDiscription(invoice.getDiscription());
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<InvoiceResponseDto> deleteInvoice(Long invoice_id) {
        Optional<Invoice> optionalInvoice = invoiceServices.getInvoiceById(invoice_id);

        if (!optionalInvoice.isPresent()) {
            throw new IllegalStateException("Customer with Id " + invoice_id + "Does Not Exist");
        }
        invoiceServices.deleteInvoice(invoice_id);
        Invoice invoice = optionalInvoice.get();
        InvoiceResponseDto response = new InvoiceResponseDto();
        response.setInvoiceId(invoice.getInvoiceId());
        response.setPrice(invoice.getPrice());
        response.setQuantity(invoice.getQuantity());
        response.setAmount(invoice.getAmount());
        response.setDiscription(invoice.getDiscription());
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity getAllInvoice() {

        return ResponseEntity.ok().body(invoiceServices.getInvoice());
    }
}