package com.example.Real.Estate.Dto;

import lombok.Data;

@Data

public class ContractRequestDto {
    private Integer cont_startdate;
    private Integer cont_enddate;
    private String purchase_type;
    private Long customerId;
}
