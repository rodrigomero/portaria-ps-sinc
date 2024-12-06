package com.mero.portaria.domain.service;

import com.mero.portaria.domain.model.Driver;
import com.mero.portaria.domain.model.dto.CreateDriverDTO;
import com.mero.portaria.domain.model.dto.DriverDTO;

import java.util.List;

public interface DriverService {
    DriverDTO findById(Integer id);

    DriverDTO saveDriver(CreateDriverDTO dto);

    List<DriverDTO> findAll();

    Driver getAttachedById(Integer id);
}
