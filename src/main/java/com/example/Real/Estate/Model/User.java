package com.example.Real.Estate.Model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;



@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity

public class User {
    @Id
    @Column(name = "user_id")
    @SequenceGenerator(
            name="user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1

    )
    @GeneratedValue(
            strategy=GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private  Long userId;
    private String email;
    private String password;
    private String userRole;



//    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//    @JsonManagedReference
//    private List<Booking> bookings;

//    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//    @JsonManagedReference
//    private List<Payment> payments;

//@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//@JsonManagedReference
// private List<Invoice> invoice;



}




