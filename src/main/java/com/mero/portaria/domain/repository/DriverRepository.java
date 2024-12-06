package com.mero.portaria.domain.repository;

import com.mero.portaria.domain.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Integer> {
}
