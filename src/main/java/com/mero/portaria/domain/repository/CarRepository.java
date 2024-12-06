package com.mero.portaria.domain.repository;

import com.mero.portaria.domain.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {
}
