package com.mero.portaria.domain.service;

import com.mero.portaria.domain.model.dto.CompanyDTO;

import java.util.List;

public interface CompanyService {
    CompanyDTO findById(Integer id);

    CompanyDTO saveCompany(CompanyDTO dto);

    List<CompanyDTO> findAll();

    CompanyDTO findByName(String name);
}
