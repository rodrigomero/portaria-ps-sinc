package com.mero.portaria.domain.service;

import com.mero.portaria.domain.model.dto.CreateInspectionDTO;
import com.mero.portaria.domain.model.dto.InspectionDTO;

import java.util.List;

public interface InspectionService {
    InspectionDTO findById(Integer id);

    InspectionDTO saveInspection(CreateInspectionDTO dto);

    List<InspectionDTO> findAll();

}
