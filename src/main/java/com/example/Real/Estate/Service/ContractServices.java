package com.example.Real.Estate.Service;

import com.example.Real.Estate.Dto.ContractRequestDto;
import com.example.Real.Estate.Dto.ContractResponseDto;
import com.example.Real.Estate.Dto.CustomerRequestDto;
import com.example.Real.Estate.Model.Contract;
import com.example.Real.Estate.Model.Customer;
import com.example.Real.Estate.Model.User;
import com.example.Real.Estate.Repository.ContractRepository;
import com.example.Real.Estate.Repository.CustomerRepository;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Data
@Service

public class ContractServices {
    private final ContractRepository contractRepository;
    private final ModelMapper modelMapper;
    private final CustomerRepository customerRepository;
    @Autowired

    public List<ContractResponseDto> getContract() {
        List<Contract> contracts=contractRepository.findAll();
        List list=new ArrayList();
        for (Contract contract:contracts)
        {
            list.add(modelMapper.map(contract,ContractResponseDto.class));
        }
        return list;
    }

    public ResponseEntity addNewContract(ContractRequestDto dto){
        Optional<Customer> customerOptional =customerRepository.findById(dto.getCustomerId());
        if(!customerOptional.isPresent()){
            throw  new IllegalStateException("Customer with Id " + dto.getCustomerId()+"Does Not exist");
        }
        Customer customer = customerOptional.get();
        Contract contract=new Contract();
        contract.setCont_startdate(dto.getCont_startdate());
        contract.setCont_enddate(dto.getCont_enddate());
        contract.setPurchase_type(dto.getPurchase_type());

        customer.setCustomerId(dto.getCustomerId());
        contract.setCustomer(customer);
        contractRepository.save(contract);
        Map map = new HashMap<String,Boolean>();
        map.put("response",Boolean.TRUE);
        return ResponseEntity.ok().body(map);
    }

    public Optional<Contract> getContractById(Long contractId){
        return contractRepository.findById(contractId);
    }
    public void deleteContract(Long contractId) {
        boolean exists = contractRepository.existsById(contractId);
        if (!exists) {
            throw new IllegalStateException("Contract with Id " + contractId + " does not exist");
        }
        contractRepository.deleteById(contractId);

    }

    public Object update(Long contract_Id, ContractRequestDto dto) {
        Optional<Customer> customerOptional =customerRepository.findById(dto.getCustomerId());
        if(!customerOptional.isPresent()){
            throw  new IllegalStateException("Customer with Id " + dto.getCustomerId()+"Does Not exist");
        }
        Optional<Contract> contract1 =contractRepository.findById(contract_Id);
        if(!customerOptional.isPresent()){
            throw  new IllegalStateException("Contract with Id " + contract_Id+"Does Not exist");
        }
        Customer customer = customerOptional.get();
        Contract contract = contract1.get();
        contract.setCont_startdate(dto.getCont_startdate());
        contract.setCont_enddate(dto.getCont_enddate());
        contract.setPurchase_type(dto.getPurchase_type());

        customer.setCustomerId(dto.getCustomerId());
        contract.setCustomer(customer);
        contractRepository.save(contract);
        Map map = new HashMap<String,Boolean>();
        map.put("response",Boolean.TRUE);
        return ResponseEntity.ok().body(map);
    }


}
