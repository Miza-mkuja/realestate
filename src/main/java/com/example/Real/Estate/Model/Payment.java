package com.example.Real.Estate.Model;

import com.example.Real.Estate.Model.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Table
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Payment {
    @Id
    @SequenceGenerator(
            name = "payment_sequence",
            sequenceName = "payment_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "payment_sequence"
    )
    private Long paymentId;
    private String paymentAmount;
    private String receiptNo;
    private String paymentReceipt;
    private String paymentStatus;




    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id",nullable = false)
    @JsonManagedReference
    private Customer customer;


    @OneToOne
    @JoinColumn(name = "invoice_id" ,nullable=false)
    @JsonBackReference
    private Invoice invoice;
}




