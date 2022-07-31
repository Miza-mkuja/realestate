package com.example.Real.Estate.Dto;

import com.example.Real.Estate.Model.Booking;
import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class HouseResponseDto {
    private Long houseId;
    private String blockNo;
    private Integer floorNo;
    private String houseNo;
    private String size;
    private String type;
    private Integer price;
    private String address;
    private String city;
    private String houseStatus;
    private String pic;
}
