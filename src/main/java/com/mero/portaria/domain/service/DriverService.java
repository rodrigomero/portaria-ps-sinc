package com.mero.portaria.domain.service;

import com.mero.portaria.domain.model.dto.DriverDTO;

import java.util.List;

public interface DriverService {
    DriverDTO findById(Integer id);

    DriverDTO saveDriver(DriverDTO dto);

    List<DriverDTO> findAll();

}
