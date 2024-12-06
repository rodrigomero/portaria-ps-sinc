package com.mero.portaria.domain.repository;

import com.mero.portaria.domain.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StaffRepository extends JpaRepository<Staff, Integer> {
    Optional<Staff> findByName(String name);
}
