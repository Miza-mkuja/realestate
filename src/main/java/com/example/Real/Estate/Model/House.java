package com.example.Real.Estate.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;


@Entity
@Table
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor


public class House {
    @Id
    @SequenceGenerator(
            name = "house_sequence",
            sequenceName = "house_sequence",
            allocationSize = 1

    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "house_sequence"
    )
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
    private byte[] pic;


//    @OneToOne
//    @JoinColumn(name = "booking_id" ,nullable=false)
//    @JsonBackReference
//    private Booking booking;

}