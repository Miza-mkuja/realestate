package com.example.Real.Estate.web.ApiController;

import com.example.Real.Estate.Dto.UserDto;
import com.example.Real.Estate.web.Api.CustomerApi;
import com.example.Real.Estate.Dto.CustomerRequestDto;
import com.example.Real.Estate.Dto.CustomerResponseDto;
import com.example.Real.Estate.Model.Customer;
import com.example.Real.Estate.Service.CustomerServices;
import com.example.Real.Estate.Service.UserServices;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@RestController

public class CustomerApiController implements CustomerApi {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    CustomerServices customerServices;

    @Autowired
    UserServices userServices;
    @Override
    public ResponseEntity createCustomer(CustomerRequestDto dto) throws InvalidKeySpecException, NoSuchAlgorithmException {

        return  ResponseEntity.ok().body(customerServices.addNewCustomer(dto));
    }

    @Override
    public ResponseEntity updateCustomer(Long customer_id, CustomerRequestDto dto) {
        return  ResponseEntity.ok().body(customerServices.update(customer_id,dto));
    }

    @Override
    public ResponseEntity<CustomerResponseDto> getCustomerById(Long customer_id) {
        Optional<Customer> optionalCustomer=customerServices.getCustomerById(customer_id);

        if(!optionalCustomer.isPresent()){
            throw new IllegalStateException("Customer with Id " + customer_id+ "Does Not Exist");
        }
        Customer customer=optionalCustomer.get();
        CustomerResponseDto response=new CustomerResponseDto();
        response.setCustomerId(customer.getCustomerId());
        response.setName(customer.getName());
        response.setAddress(customer.getAddress());
        response.setPhoneNo(customer.getPhoneNo());
        response.setNationality(customer.getNationality());
        response.setBankAccount(customer.getBankAccount());
        response.setBankName(customer.getBankName());
        response.setEmployeeStatus(customer.getEmployeeStatus());
        response.setMaritalStatus(customer.getMaritalStatus());
        response.setZanId(customer.getZanId());
        response.setEmail(customer.getEmail());
        response.setPassword(customer.getPassword());
        response.setUserRole(customer.getUserRole());
        return  ResponseEntity.ok(response);
}

    @Override
    public ResponseEntity<CustomerResponseDto> deleteCustomer(Long customer_id) {
        Optional<Customer> optionalCustomer=customerServices.getCustomerById(customer_id);

        if(!optionalCustomer.isPresent()){
            throw new IllegalStateException("Customer with Id " + customer_id+ "Does Not Exist");
        }
        customerServices.deleteCustomer(customer_id);
        Customer customer=optionalCustomer.get();
        CustomerResponseDto response=new CustomerResponseDto();
        response.setCustomerId(customer.getCustomerId());
        response.setName(customer.getName());
        response.setAddress(customer.getAddress());
        response.setPhoneNo(customer.getPhoneNo());
        response.setNationality(customer.getNationality());
        response.setBankAccount(customer.getBankAccount());
        response.setBankName(customer.getBankName());
        response.setEmployeeStatus(customer.getEmployeeStatus());
        response.setMaritalStatus(customer.getMaritalStatus());
        response.setZanId(customer.getZanId());
        response.setEmail(customer.getEmail());
        response.setPassword(customer.getPassword());
        response.setUserRole(customer.getUserRole());
        return  ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity getAllCustomer() {

        return ResponseEntity.ok().body(customerServices.getCustomer());

    }

    @Override
    public ResponseEntity auth(UserDto userDto) {
        return ResponseEntity.ok().body(customerServices.authLoging(userDto));
    }

//        List<CustomerResponseDto> response = customerServices.getCustomer().stream().map(customer -> modelMapper.map(customer, CustomerResponseDto.class))
//                .collect(Collectors.toList());
//        return new ResponseEntity<List<CustomerResponseDto>>(response, HttpStatus.OK);

    }

