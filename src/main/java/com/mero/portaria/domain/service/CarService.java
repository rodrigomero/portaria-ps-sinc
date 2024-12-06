package com.mero.portaria.domain.service;

import com.mero.portaria.domain.model.Car;
import com.mero.portaria.domain.model.dto.CarDTO;

import java.util.List;

public interface CarService {
    CarDTO findById(Integer id);

    CarDTO saveCar(CarDTO dto);

    List<CarDTO> findAll();

    Car getAttachedById(Integer id);
}
