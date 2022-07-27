package com.example.Real.Estate.Dto;


import com.example.Real.Estate.Model.Customer;
import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor


public class ContractResponseDto {
    private Long contractId;
    private Integer cont_startdate;
    private Integer cont_enddate;
    private String purchase_type;
    private Customer customer;
}
