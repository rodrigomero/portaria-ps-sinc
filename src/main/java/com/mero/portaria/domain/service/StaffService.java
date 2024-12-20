package com.mero.portaria.domain.service;

import com.mero.portaria.domain.model.Staff;
import com.mero.portaria.domain.model.dto.LoginDTO;
import com.mero.portaria.domain.model.dto.StaffDTO;
import jakarta.validation.Valid;

import java.util.List;

public interface StaffService {
    StaffDTO findById(Integer id);

    StaffDTO saveStaff(StaffDTO dto);

    List<StaffDTO> findAll();

    StaffDTO findByName(String name);

    Staff getAttachedById(Integer id);

    StaffDTO login(@Valid LoginDTO dto);
}
