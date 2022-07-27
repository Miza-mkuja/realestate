package com.example.Real.Estate.Dto;


import lombok.Data;

@Data

public class HouseRequestDto {

    private String blockNo;
    private Integer floorNo;
    private String houseNo;
    private String size;
    private String type;
    private Integer price;
    private String address;
    private String city;
    private String houseStatus;
    private byte[] pic;

}
