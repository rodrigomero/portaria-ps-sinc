package com.mero.portaria.domain.service;

import com.mero.portaria.domain.model.dto.InspectionDTO;

import java.util.List;

public interface InspectionService {
    InspectionDTO findById(Integer id);

    InspectionDTO saveInspection(InspectionDTO dto);

    List<InspectionDTO> findAll();

}
