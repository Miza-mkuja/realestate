package com.example.Real.Estate.web.Api;

import com.example.Real.Estate.Dto.CustomerRequestDto;
import com.example.Real.Estate.Dto.CustomerResponseDto;
import com.example.Real.Estate.Dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Map;

@CrossOrigin
@RequestMapping("api/customer")
public interface CustomerApi {
    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity<CustomerResponseDto> createCustomer(@RequestBody CustomerRequestDto dto) throws InvalidKeySpecException, NoSuchAlgorithmException;

    @RequestMapping(value = "/{customer_id}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public ResponseEntity<CustomerResponseDto> updateCustomer(@PathVariable Long customer_id, @RequestBody CustomerRequestDto dto);

    @RequestMapping(value = "/{customer_id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<CustomerResponseDto> getCustomerById(@PathVariable Long customer_id);

    @RequestMapping(value = "/{customer_id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<CustomerResponseDto> deleteCustomer(@PathVariable Long customer_id);

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Map<String, Object>> getAllCustomer();

    @RequestMapping(value = "/getAuth", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity auth(@RequestBody UserDto userDto);

}
