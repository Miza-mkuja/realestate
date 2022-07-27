package com.example.Real.Estate.web.ApiController;


import com.example.Real.Estate.Dto.HouseRequestDto;
import com.example.Real.Estate.Dto.HouseResponseDto;
import com.example.Real.Estate.Model.House;
import com.example.Real.Estate.Service.BookingService2;
import com.example.Real.Estate.Service.HouseServices;
import com.example.Real.Estate.web.Api.HouseApi;
import lombok.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@RestController

public class HouseApiController implements HouseApi {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    HouseServices houseServices;

    @Autowired
    BookingService2 bookingServices;

    @Override
    public ResponseEntity createHouse(HouseRequestDto dto) {

        return  ResponseEntity.ok().body(houseServices.addNewHouse(dto));
    }

    @Override
    public ResponseEntity updateHouse(Long house_id, HouseRequestDto dto) {
        return  ResponseEntity.ok().body(houseServices.update(house_id,dto));
    }

    @Override
    public ResponseEntity<HouseResponseDto> getHouseById(Long house_id) {

            Optional<House> optionalHouse=houseServices.getHouseById(house_id);

            if(!optionalHouse.isPresent()){
                throw new IllegalStateException("House with Id " + house_id+ "Does Not Exist");
            }
            House house=optionalHouse.get();
            HouseResponseDto response=new HouseResponseDto();
            response.setHouseId(house.getHouseId());
            response.setBlockNo(house.getBlockNo());
            response.setFloorNo(house.getFloorNo());
            response.setHouseNo(house.getHouseNo());
            response.setSize(house.getSize());
            response.setType(house.getType());
            response.setPrice(house.getPrice());
            response.setAddress(house.getAddress());
            response.setCity(house.getCity());
            response.setHouseStatus(house.getHouseStatus());
            response.setPic(house.getPic());
            return  ResponseEntity.ok(response);

    }

    @Override
    public ResponseEntity<HouseResponseDto> deleteHouse(Long house_id) {
        Optional<House> optionalHouse=houseServices.getHouseById(house_id);

        if(!optionalHouse.isPresent()){
            throw new IllegalStateException("House with Id " + house_id+ "Does Not Exist");
        }
        houseServices.deleteHouse(house_id);
        House house=optionalHouse.get();
        HouseResponseDto response=new HouseResponseDto();
        response.setHouseId(house.getHouseId());
        response.setBlockNo(house.getBlockNo());
        response.setFloorNo(house.getFloorNo());
        response.setHouseNo(house.getHouseNo());
        response.setSize(house.getSize());
        response.setType(house.getType());
        response.setPrice(house.getPrice());
        response.setAddress(house.getAddress());
        response.setCity(house.getCity());
        response.setHouseStatus(house.getHouseStatus());
        response.setPic(house.getPic());
        return  ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity getAllHouse() {
        return ResponseEntity.ok().body(houseServices.getHouse());
    }


//      @Override
//    public ResponseEntity uploadPicture() {
//         ResponseEntity <HouseResponseDto> uploadPicture(@RequestParam("") MultipartFile file)
       //return ResponseEntity.ok().body(houseServices.getHouse());
       //public House uploadImage(@RequestParam("myFile") MultipartFile file) throws IOException{

          //};
//    }

}


