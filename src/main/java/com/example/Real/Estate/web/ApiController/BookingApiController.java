package com.example.Real.Estate.web.ApiController;

import com.example.Real.Estate.Dto.BookingRespoDto;
import com.example.Real.Estate.Service.BookingService2;
import com.example.Real.Estate.Service.CustomerServices;
import com.example.Real.Estate.Service.HouseServices;
import com.example.Real.Estate.web.Api.BookingApi;
import com.example.Real.Estate.Dto.BookingRequestDto;
import com.example.Real.Estate.Model.Booking;
import lombok.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Data
@RestController
@AllArgsConstructor
@NoArgsConstructor


public class BookingApiController implements BookingApi {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    BookingService2 bookingServices;
    @Autowired
    CustomerServices customerServices;
    @Autowired
    HouseServices houseServices;

    @Override
    public ResponseEntity createBooking(BookingRequestDto dto) {

        return  ResponseEntity.ok().body(bookingServices.AddBooking(dto));
    }

    @Override
    public ResponseEntity updateBooking(Long booking_id, BookingRequestDto dto) {
        return  ResponseEntity.ok().body(bookingServices.update(booking_id,dto));

    }

    @Override
    public ResponseEntity getBookingByPayment(int recieptNo, Long booking_id) {
        return ResponseEntity.ok().body(bookingServices.payment(recieptNo,booking_id));
    }


    @Override
    public ResponseEntity<BookingRespoDto> getBookingById(Long booking_id) {
        Optional<Booking> OptionalBooking = bookingServices.getBookingById(booking_id);
        if (!OptionalBooking.isPresent()) {
            throw new IllegalStateException("Booking with " + booking_id + " Does Not exist");
        }
        Booking booking =OptionalBooking.get();
        BookingRespoDto response = new BookingRespoDto();
        response.setBookingId(booking.getBookingId());
        response.setBookingRequest(booking.getBookingRequest());
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity changestatus(Long booking_id) {
        return ResponseEntity.ok(bookingServices.accept(booking_id));
    }

    @Override
    public ResponseEntity getBookingByPayments(int statusPayment, Long customerId) {
        return ResponseEntity.ok().body(bookingServices.getAllBookingPayment(statusPayment,customerId));
    }

    @Override
    public ResponseEntity getBookingByInvoice(int status, Long customerId) {
        return ResponseEntity.ok().body(bookingServices.getAllBookingInvoice(status,customerId));
    }

    @Override
    public ResponseEntity<BookingRespoDto> deleteBooking(Long booking_id) {
        Optional<Booking> optionalBooking=bookingServices.getBookingById(booking_id);

        if(!optionalBooking.isPresent()){
            throw new IllegalStateException("Booking with Id " + booking_id+ "Does Not Exist");
        }
        bookingServices.deleteBooking(booking_id);
        Booking booking=optionalBooking.get();
        BookingRespoDto response = new BookingRespoDto();
        response.setBookingId(booking.getBookingId());
        response.setBookingRequest(booking.getBookingRequest());
        return  ResponseEntity.ok(response);

    }

    @Override
    public ResponseEntity getAllBooking() {
        return ResponseEntity.ok().body(bookingServices.getAllBooking());

    }
}



