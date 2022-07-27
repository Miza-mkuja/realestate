package com.example.Real.Estate.web.Api;


import com.example.Real.Estate.Dto.ContractRequestDto;
import com.example.Real.Estate.Dto.ContractResponseDto;
import com.example.Real.Estate.Dto.CustomerRequestDto;
import com.example.Real.Estate.Dto.CustomerResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RequestMapping("api/contract")

public interface ContractApi {
    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity<ContractResponseDto> createContract(@RequestBody ContractRequestDto dto);

    @RequestMapping(value = "/{contract_id}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public ResponseEntity<ContractResponseDto> updateContract(@PathVariable Long contract_id, @RequestBody ContractRequestDto dto);

    @RequestMapping(value = "/{contract_id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<ContractResponseDto> getContractById(@PathVariable Long contract_id);

    @RequestMapping(value = "/{contract_id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<ContractResponseDto> deleteContract(@PathVariable Long contract_id);

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Map<String, Object>> getAllContract();

}
