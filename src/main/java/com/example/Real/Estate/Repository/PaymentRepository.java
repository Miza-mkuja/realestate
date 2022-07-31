package com.example.Real.Estate.Repository;

import com.example.Real.Estate.Model.Payment;
import com.example.Real.Estate.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface PaymentRepository extends JpaRepository<Payment,Long> {
    Optional<Payment> findByPaymentReceipt (String paymentReceipt);


}
