package com.example.Real.Estate.Repository;

import com.example.Real.Estate.Model.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface HouseRepository extends JpaRepository<House,Long> {
    Optional<House> findByHouseNo(String houseNo);
}
