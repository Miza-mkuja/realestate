package com.example.Real.Estate.Service;

import com.example.Real.Estate.Dto.BookingRequestDto;
import com.example.Real.Estate.Dto.BookingRespoDto;
import com.example.Real.Estate.Model.Booking;
import com.example.Real.Estate.Model.Customer;
import com.example.Real.Estate.Model.House;
import com.example.Real.Estate.Repository.BookingRepository;
import com.example.Real.Estate.Repository.CustomerRepository;
import com.example.Real.Estate.Repository.HouseRepository;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Data
@Service
public class BookingService2 {
    private final BookingRepository bookingRepository;
    private final ModelMapper modelMapper;
    private final CustomerRepository customerRepository;
    private final HouseRepository houseRepository;
    public ResponseEntity AddBooking(BookingRequestDto dto) {
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        System.out.println(dto);
        Optional<Customer> customerOptional = customerRepository.findById(dto.getCustomerId());
        if (!customerOptional.isPresent()) {
            throw new IllegalStateException("Customer with Id " + dto.getCustomerId() + "Does Not exist");
        }

        Optional<House> houseOptional = houseRepository.findById(dto.getHouseId());
        if (!houseOptional.isPresent()) {
            throw new IllegalStateException("House with Id " + dto.getHouseId() + "Does Not exist");
        }
        Customer customer = customerOptional.get();
        House house = houseOptional.get();
        Booking booking = modelMapper.map(dto,Booking.class);
        booking.setStatus(1);
        bookingRepository.save(booking);
        Map map = new HashMap<String, Boolean>();
        map.put("response", Boolean.TRUE);
        return ResponseEntity.ok().body(map);
    }

    public List<BookingRespoDto> getAllBooking(){
        List<Booking> bookings=bookingRepository.findAll();
        List list = new ArrayList();
        for (Booking booking:bookings)
        {
            list.add(modelMapper.map(booking, BookingRespoDto.class));
        }
        return list;
    }

    public ResponseEntity payment(int receiptNo,Long bookingId){
        Optional<Booking> findById=bookingRepository.findById(bookingId);
        if(!findById.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,bookingId.toString());
        }
        findById.get().setReceiptNo(receiptNo);
        findById.get().setStatusPayment(1);
        bookingRepository.save(findById.get());
        return  ResponseEntity.ok().body(Boolean.TRUE);
    }

    public List<BookingRespoDto> getAllBookingInvoice(int status ,Long customerId){
        List<Booking> bookings=bookingRepository.findInvoice(status,customerId);
        List list = new ArrayList();
        for (Booking booking:bookings)
        {
            list.add(modelMapper.map(booking, BookingRespoDto.class));
        }
        return list;
    }
    public List<BookingRespoDto> getAllBookingPayment(int statusPayment ,Long customerId){
        List<Booking> bookings=bookingRepository.findPayment(statusPayment,customerId);
        List list = new ArrayList();
        for (Booking booking:bookings)
        {
            list.add(modelMapper.map(booking, BookingRespoDto.class));
        }
        return list;
    }

    public Optional<Booking> getBookingById(Long bookingId) {
        return bookingRepository.findById(bookingId);
    }

    public Object update(Long booking_id, BookingRequestDto dto) {
        Optional<Customer> customerOptional =customerRepository.findById(dto.getCustomerId());
        if(!customerOptional.isPresent()){
            throw  new IllegalStateException("Customer with Id " + dto.getCustomerId()+"Does Not exist");
        }
        Optional<Booking> booking =bookingRepository.findById(booking_id);
        if(!customerOptional.isPresent()){
            throw  new IllegalStateException("booking with Id " + booking_id+"Does Not exist");
        }
        Customer customer = customerOptional.get();
        Booking booking1 = booking.get();
        booking1.setBookingRequest(dto.getBookingRequest());


        customer.setCustomerId(dto.getCustomerId());
        booking1.setCustomer(customer);
        bookingRepository.save(booking1);
        Map map = new HashMap<String,Boolean>();
        map.put("response",Boolean.TRUE);
        return ResponseEntity.ok().body(map);
    }




    public void deleteBooking(Long bookingId){
        boolean exists=bookingRepository.existsById(bookingId);
        if(!exists){
            throw new IllegalStateException("Booking with Id"+ bookingId+ "does not exist");
        }
        bookingRepository.deleteById(bookingId);
    }

    public ResponseEntity accept(Long booking_id) {
        Optional<Booking> booking =bookingRepository.findById(booking_id);
        if(!booking.isPresent()){
            throw  new IllegalStateException("booking with Id " + booking_id+"Does Not exist");
        }

        switch (booking.get().getStatus()){
            case 1:
                booking.get().setStatus(2);
                break;
            case 2:
                booking.get().setStatus(1);
                break;
        }
        bookingRepository.save(booking.get());
        return ResponseEntity.ok(Boolean.TRUE);

    }

}
