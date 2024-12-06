package com.mero.portaria.domain.service;

import com.mero.portaria.domain.model.InspectionDetails;
import com.mero.portaria.domain.model.dto.InspectionDetailsDTO;

import java.util.List;

public interface InspectionDetailsService {
    InspectionDetailsDTO findById(Integer id);

    InspectionDetails saveInspectionDetails(InspectionDetailsDTO dto);

    List<InspectionDetailsDTO> findAll();

}
