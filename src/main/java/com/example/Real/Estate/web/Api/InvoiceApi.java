package com.example.Real.Estate.web.Api;


import com.example.Real.Estate.Dto.CustomerRequestDto;
import com.example.Real.Estate.Dto.CustomerResponseDto;
import com.example.Real.Estate.Dto.InvoiceRequestDto;
import com.example.Real.Estate.Dto.InvoiceResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RequestMapping("api/invoice")


public interface InvoiceApi {
    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity<InvoiceResponseDto> createInvoice(@RequestBody InvoiceRequestDto dto);

    @RequestMapping(value = "/{invoice_id}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public ResponseEntity<InvoiceResponseDto> updateInvoice(@PathVariable Long invoice_id, @RequestBody InvoiceRequestDto dto);

    @RequestMapping(value = "/{invoice_id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<InvoiceResponseDto> getInvoiceById(@PathVariable Long invoice_id);

    @RequestMapping(value = "/{invoice_id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<InvoiceResponseDto> deleteInvoice(@PathVariable Long invoice_id);

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Map<String, Object>> getAllInvoice();
}
