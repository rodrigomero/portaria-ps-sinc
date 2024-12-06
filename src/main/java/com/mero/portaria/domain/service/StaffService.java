package com.mero.portaria.domain.service;

import com.mero.portaria.domain.model.dto.StaffDTO;

import java.util.List;

public interface StaffService {
    StaffDTO findById(Integer id);

    StaffDTO saveStaff(StaffDTO dto);

    List<StaffDTO> findAll();

    StaffDTO findByName(String name);
}
