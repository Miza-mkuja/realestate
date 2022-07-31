package com.example.Real.Estate.Repository;

import com.example.Real.Estate.Model.Booking;
import com.example.Real.Estate.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository

public interface BookingRepository extends JpaRepository<Booking,Long>{
    @Query(value = "select * from booking where status=?1 and customer_id=?2",nativeQuery = true)
    List<Booking> findInvoice(int status, Long customerid);

    @Query(value = "select * from booking where status_payment=?1 and customer_id=?2",nativeQuery = true)
    List<Booking> findPayment(int statusPayment, Long customerid);

    List<Booking> findByStatusPayment(int sp);

}
