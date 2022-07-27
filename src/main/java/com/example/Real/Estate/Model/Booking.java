package com.example.Real.Estate.Model;

import com.example.Real.Estate.Model.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
@Table
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Booking {
    @Id
    @SequenceGenerator(
            name = "booking_sequence",
            sequenceName = "booking_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator= "booking_sequence"
    )
    private Long bookingId;
    private String bookingRequest;
    private int status;
    private int statusPayment;
    private int receiptNo;

    @ManyToOne
    @JoinColumn(name = "customer_id" ,nullable=false)
    @JsonBackReference
    private Customer customer;


    @ManyToOne
    @JoinColumn(name = "house_id" ,nullable=false)
    @JsonBackReference
    private House house;

}

