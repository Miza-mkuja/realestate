package com.example.Real.Estate.Repository;

import com.example.Real.Estate.Model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ContractRepository extends JpaRepository<Contract,Long> {
}
