package com.example.Real.Estate.web.ApiController;


import com.example.Real.Estate.Dto.ContractRequestDto;
import com.example.Real.Estate.Dto.ContractResponseDto;
import com.example.Real.Estate.Dto.CustomerRequestDto;
import com.example.Real.Estate.Dto.CustomerResponseDto;
import com.example.Real.Estate.Model.Contract;
import com.example.Real.Estate.Model.Customer;
import com.example.Real.Estate.Service.ContractServices;
import com.example.Real.Estate.Service.CustomerServices;
import com.example.Real.Estate.Service.UserServices;
import com.example.Real.Estate.web.Api.ContractApi;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RestController

public class ContractApiController implements ContractApi {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    ContractServices contractServices;

    @Autowired
    CustomerServices customerServices;

    @Override
    public ResponseEntity createContract(ContractRequestDto dto) {

        return ResponseEntity.ok().body(contractServices.addNewContract(dto));

    }

    @Override
    public ResponseEntity updateContract(Long contract_id, ContractRequestDto dto) {
        return ResponseEntity.ok().body(contractServices.update(contract_id, dto));
    }

    @Override
    public ResponseEntity<ContractResponseDto> getContractById(Long contract_id) {
        Optional<Contract> optionalContract = contractServices.getContractById(contract_id);

        if (!optionalContract.isPresent()) {
            throw new IllegalStateException("Contract with Id " + contract_id + "Does Not Exist");
        }
        Contract contract = optionalContract.get();
        ContractResponseDto response = new ContractResponseDto();
        response.setContractId(contract.getContractId());
        response.setCont_startdate(contract.getCont_startdate());
        response.setCont_enddate(contract.getCont_enddate());
        response.setPurchase_type(contract.getPurchase_type());
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<ContractResponseDto> deleteContract(Long contract_id) {
        Optional<Contract> optionalContract = contractServices.getContractById(contract_id);

        if (!optionalContract.isPresent()) {
            throw new IllegalStateException("Contract with Id " + contract_id + "Does Not Exist");
        }
        contractServices.deleteContract(contract_id);
        Contract contract = optionalContract.get();
        ContractResponseDto response = new ContractResponseDto();
        response.setContractId(contract.getContractId());
        response.setCont_startdate(contract.getCont_startdate());
        response.setCont_enddate(contract.getCont_enddate());
        response.setPurchase_type(contract.getPurchase_type());
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity getAllContract() {

        return ResponseEntity.ok().body(contractServices.getContract());
    }
}



