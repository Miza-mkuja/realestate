package com.example.Real.Estate.web.Api;


import com.example.Real.Estate.Dto.BookingRequestDto;
import com.example.Real.Estate.Dto.BookingRespoDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

//import java.util.Map;

@CrossOrigin
//@RequestMapping("api/booking")
@RequestMapping("api/booking")


public interface BookingApi {
    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity<BookingRespoDto> createBooking(@RequestBody BookingRequestDto dto);

    @RequestMapping(value = "/{booking_id}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public ResponseEntity<BookingRespoDto> updateBooking(@PathVariable Long booking_id, @RequestBody BookingRequestDto dto);

    @RequestMapping(value = "/payment/{receiptNo}/{booking_id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getBookingByPayment(@PathVariable("receiptNo") int receiptNo,@PathVariable("booking_id") Long booking_id);


    @RequestMapping(value = "/{booking_id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<BookingRespoDto> getBookingById(@PathVariable Long booking_id);


    @RequestMapping(value = "/change-status/{booking_id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity changestatus(@PathVariable("booking_id") Long booking_id);

    @RequestMapping(value = "/get-payment/{statusPayment}/{customerId}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getBookingByPayments(@PathVariable("statusPayment") int statusPayment,@PathVariable("customerId") Long customerId);


    @RequestMapping(value = "/get-invoice/{status}/{customerId}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getBookingByInvoice(@PathVariable("status") int status,@PathVariable("customerId") Long customerId);

    @RequestMapping(value = "/{booking_id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<BookingRespoDto> deleteBooking(@PathVariable Long booking_id);

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Map<String, Object>> getAllBooking();


}
