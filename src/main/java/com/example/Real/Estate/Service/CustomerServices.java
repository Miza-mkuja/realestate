package com.example.Real.Estate.Service;


import com.example.Real.Estate.Dto.ContractRequestDto;
import com.example.Real.Estate.Dto.CustomerRequestDto;
import com.example.Real.Estate.Dto.CustomerResponseDto;
import com.example.Real.Estate.Dto.UserDto;
import com.example.Real.Estate.Model.Customer;
import com.example.Real.Estate.Model.User;
import com.example.Real.Estate.Repository.CustomerRepository;
import com.example.Real.Estate.Repository.UserRepository;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
//import java.security.SecureRandom;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.*;

@Service
@Data

public class CustomerServices {
    private  final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;
    private  final UserRepository userRepository;
    //private  SecureRandom random;
    @Autowired
    public List<CustomerResponseDto> getCustomer() {
        List<Customer> customers=customerRepository.findAll();
        List list = new ArrayList();
        for (Customer customer:customers)
        {
            list.add(modelMapper.map(customer,CustomerResponseDto.class));
        }
        return list;
    }

    public ResponseEntity addNewCustomer(CustomerRequestDto dto) throws InvalidKeySpecException, NoSuchAlgorithmException {
//        Optional<User> userOptional =userRepository.findById(dto.getUserId());
//        if(!userOptional.isPresent()){
//            throw  new IllegalStateException("User with Id " + dto.getUserId()+"Does Not exist");
//        }
//        User user = userOptional.get();
//        byte[] salt = new byte[16];
//          random.nextBytes(salt);
//        KeySpec spec = new PBEKeySpec(dto.getPassword().toCharArray(), salt, 65536, 128);
//        SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
//        byte[] hash = f.generateSecret(spec).getEncoded();
//        Base64.Encoder enc = Base64.getEncoder();
//        System.out.println(enc.encodeToString(hash));
//        System.out.println();
        Customer customer=new Customer();
        customer.setName(dto.getName());
        customer.setAddress(dto.getAddress());
        customer.setPhoneNo(dto.getPhoneNo());
        customer.setNationality(dto.getNationality());
        customer.setBankAccount(dto.getBankAccount());
        customer.setBankName(dto.getBankName());
        customer.setEmployeeStatus(dto.getEmployeeStatus());
        customer.setMaritalStatus(dto.getMaritalStatus());
        customer.setEmail(dto.getEmail());
        customer.setPassword(dto.getPassword());
        customer.setUserRole(dto.getUserRole());
//        customer.setZssfId(dto.getZssfId());
//        user.setUserId(dto.getUserId());
//        customer.setUser(user);
        customerRepository.save(customer);
        Map map = new HashMap<String,Boolean>();
        map.put("response",Boolean.TRUE);
        return ResponseEntity.ok().body(map);
    }
    public Optional<Customer> getCustomerById(Long customerId){
        return customerRepository.findById(customerId);
    }
    public void deleteCustomer(Long customerId ){
        boolean exists= customerRepository.existsById(customerId);
        if(!exists){
            throw new IllegalStateException("Customer with Id "+ customerId+" does not exist");
        }
        customerRepository.deleteById(customerId);
    }

    public Object update(Long customer_id, CustomerRequestDto dto) {
//        Optional<User> userOptional =userRepository.findById(dto.getUserId());
//        if(!userOptional.isPresent()){
//            throw  new IllegalStateException("User with Id " + dto.getUserId()+"Does Not exist");
//        }
       Optional<Customer> customer1 =customerRepository.findById(customer_id);
//        if(!userOptional.isPresent()){
//            throw  new IllegalStateException("User with Id " + customer_id+"Does Not exist");
//        }
//        User user = userOptional.get();
        Customer customer = customer1.get();
        customer.setName(dto.getName());
        customer.setAddress(dto.getAddress());
        customer.setPhoneNo(dto.getPhoneNo());
        customer.setNationality(dto.getNationality());
        customer.setBankAccount(dto.getBankAccount());
        customer.setBankName(dto.getBankName());
        customer.setEmployeeStatus(dto.getEmployeeStatus());
        customer.setMaritalStatus(dto.getMaritalStatus());
        customer.setZanId(dto.getZanId());
        customer.setEmail(dto.getEmail());
        customer.setPassword(dto.getPassword());
        customer.setUserRole(dto.getUserRole());

        customerRepository.save(customer);
        Map map = new HashMap<String,Boolean>();
        map.put("response",Boolean.TRUE);
        return ResponseEntity.ok().body(map);
    }


    public ResponseEntity authLoging(UserDto userDto){
        CustomerResponseDto customerResponseDto=null;
        List list = new ArrayList();
        Map<String,Boolean> response = new HashMap<>();
        Map<String,Object> response1 = new HashMap<>();
        for(Customer customer:customerRepository.findAll()){
            if(userDto.getEmail().equals(customer.getEmail()) && userDto.getPassword().equals(customer.getPassword())){
                customerResponseDto=modelMapper.map(customer,CustomerResponseDto.class);
                list.add(customerResponseDto);
            }
        }

        if(list.size()==0){
            response.put("response",Boolean.FALSE);
            response1.put("response",response);
        }else {
            response1.put("response",Boolean.TRUE);
            response1.put("data",customerResponseDto);

        }
       return ResponseEntity.ok().body(response1);

    }



}
