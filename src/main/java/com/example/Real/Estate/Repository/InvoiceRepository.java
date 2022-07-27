package com.example.Real.Estate.Repository;

import com.example.Real.Estate.Model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface InvoiceRepository extends JpaRepository<Invoice,Long> {
}
