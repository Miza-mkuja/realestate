package com.example.Real.Estate.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;


@Entity
@Table
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Contract {
    @Id
    @SequenceGenerator(
            name="contract_sequence",
            sequenceName= "contract_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator= "contract_sequence"
    )
    private Long contractId;
    private Integer cont_startdate;
    private Integer cont_enddate;
    private String purchase_type;

    @OneToOne
    @JoinColumn(name = "customer_id",nullable = false)
    @JsonBackReference
    private Customer customer;




}
