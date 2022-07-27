package com.example.Real.Estate.web.Api;


import com.example.Real.Estate.Dto.CustomerRequestDto;
import com.example.Real.Estate.Dto.CustomerResponseDto;
import com.example.Real.Estate.Dto.HouseRequestDto;
import com.example.Real.Estate.Dto.HouseResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RequestMapping("api/house")

public interface HouseApi {
    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity<HouseResponseDto> createHouse(@RequestBody HouseRequestDto dto);

    @RequestMapping(value = "/{house_id}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public ResponseEntity<HouseResponseDto> updateHouse(@PathVariable Long house_id, @RequestBody HouseRequestDto dto);

    @RequestMapping(value = "/{house_id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<HouseResponseDto> getHouseById(@PathVariable Long house_id);

    @RequestMapping(value = "/{house_id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<HouseResponseDto> deleteHouse(@PathVariable Long house_id);

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Map<String, Object>> getAllHouse();

//
//     @RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
//     public ResponseEntity<Map<String, Object>> uploadPicture();


}
