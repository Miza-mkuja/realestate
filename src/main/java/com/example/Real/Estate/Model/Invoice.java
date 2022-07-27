package com.example.Real.Estate.Model;

import com.example.Real.Estate.Model.User;
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

public class Invoice {
    @Id
    @SequenceGenerator(
            name = "invoice_sequence",
            sequenceName = "invoice_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "invoice_sequence"
    )

    private Long invoiceId;
    private Integer price;
    private Integer quantity;
    private Integer amount;
    private String discription;

    @ManyToOne
    @JoinColumn(name = "customer_id" ,nullable=false)
    @JsonBackReference
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "booking_id" ,nullable=false)
    @JsonBackReference
    private Booking booking;
}

