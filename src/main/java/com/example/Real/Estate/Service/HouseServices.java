package com.example.Real.Estate.Service;

import com.example.Real.Estate.Dto.CustomerRequestDto;
import com.example.Real.Estate.Dto.CustomerResponseDto;
import com.example.Real.Estate.Dto.HouseRequestDto;
import com.example.Real.Estate.Dto.HouseResponseDto;
import com.example.Real.Estate.Model.Booking;
import com.example.Real.Estate.Model.Customer;
import com.example.Real.Estate.Model.House;
import com.example.Real.Estate.Model.User;
import com.example.Real.Estate.Repository.BookingRepository;
import com.example.Real.Estate.Repository.CustomerRepository;
import com.example.Real.Estate.Repository.HouseRepository;
import com.example.Real.Estate.Repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Data
@AllArgsConstructor
public class HouseServices {
    private final HouseRepository houseRepository;
    private final ModelMapper modelMapper;
    //private final BookingRepository bookingRepository;


    public List<HouseResponseDto> getHouse() {
        List<House> houses = houseRepository.findAll();
        List<HouseResponseDto> list = new ArrayList();
        for (House house : houses) {
            HouseResponseDto hr = new HouseResponseDto();
            hr.setHouseId(house.getHouseId());
            hr.setHouseNo(house.getHouseNo());
            hr.setHouseStatus(house.getHouseStatus());
            hr.setCity(house.getCity());
            hr.setAddress(house.getAddress());
            hr.setPrice(house.getPrice());
            hr.setType(house.getType());
            hr.setBlockNo(house.getBlockNo());
            hr.setSize(house.getSize());
            hr.setFloorNo(house.getFloorNo());
            hr.setPic(house.getPic());
            list.add(hr);
        }
        return list;
    }

    public ResponseEntity addNewHouse(HouseRequestDto dto) {
        //Optional<Booking> bookingOptional = bookingRepository.findById(dto.getBookingId());
       // if (!bookingOptional.isPresent()) {
         //   throw new IllegalStateException("Booking with Id " + dto.getBookingId() + "Does Not exist");
      //  }
       // Booking booking = bookingOptional.get();
        House house = new House();
        house.setBlockNo(dto.getBlockNo());
        house.setFloorNo(dto.getFloorNo());
        house.setHouseNo(dto.getHouseNo());
        house.setSize(dto.getSize());
        house.setType(dto.getType());
        house.setPrice(dto.getPrice());
        house.setAddress(dto.getAddress());
        house.setCity(dto.getCity());
        house.setHouseStatus(dto.getHouseStatus());
        house.setPic(dto.getPic());
       // house.setBooking(booking);
        houseRepository.save(house);
        Map map = new HashMap<String, Boolean>();
        map.put("response", Boolean.TRUE);
        return ResponseEntity.ok().body(map);
    }


    public Optional<House> getHouseById(Long houseId) {
        return houseRepository.findById(houseId);
    }

    public void deleteHouse(Long houseId) {
        boolean exists = houseRepository.existsById(houseId);
        if (!exists) {
            throw new IllegalStateException("House with Id " + houseId + " does not exist");
        }
        houseRepository.deleteById(houseId);
    }


    public Object update(Long house_id, HouseRequestDto dto) {
      //  Optional<Booking> bookingOptional = bookingRepository.findById(dto.getBookingId());
      //  if (!bookingOptional.isPresent()) {
         //   throw new IllegalStateException("Booking with Id " + dto.getBookingId() + "Does Not exist");
        //}
        Optional<House> house1 = houseRepository.findById(house_id);
        if (!house1.isPresent()) {
            throw new IllegalStateException("House with Id " + house_id + "Does Not exist");
        }

       // Booking booking = bookingOptional.get();
        House house = house1.get();
        house.setBlockNo(dto.getBlockNo());
        house.setFloorNo(dto.getFloorNo());
        house.setHouseNo(dto.getHouseNo());
        house.setSize(dto.getSize());
        house.setType(dto.getType());
        house.setPrice(dto.getPrice());
        house.setAddress(dto.getAddress());
        house.setCity(dto.getCity());
        house.setHouseStatus(dto.getHouseStatus());
        house.setPic(house.getPic());
        houseRepository.save(house);
        Map map = new HashMap<String, Boolean>();
        map.put("response", Boolean.TRUE);
        return ResponseEntity.ok().body(map);
    }
}











