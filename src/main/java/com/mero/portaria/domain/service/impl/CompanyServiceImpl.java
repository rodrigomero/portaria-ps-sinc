package com.mero.portaria.domain.service.impl;

import com.mero.portaria.domain.model.Company;
import com.mero.portaria.domain.model.dto.CompanyDTO;
import com.mero.portaria.domain.repository.CompanyRepository;
import com.mero.portaria.domain.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository repository;

    @Override
    public CompanyDTO findById(Integer id) {

        return repository.findById(id)
                .map(CompanyDTO::toDTO)
                .orElseThrow(() -> new RuntimeException("Nenhuma empresa encontrada para o ID informado"));
    }

    @Override
    public CompanyDTO findByName(String name) {

        return repository.findByName(name)
                .map(CompanyDTO::toDTO)
                .orElseThrow(() -> new RuntimeException("Nenhuma empresa encontrada para o nome informado"));
    }

    @Override
    public CompanyDTO saveCompany(CompanyDTO dto) {
        if (dto.getId() != null) {
            return updateCompany(dto);
        }
        Company entity = dto.toEntity();
        repository.save(entity);
        dto.setId(entity.getId());
        return dto;
    }

    private CompanyDTO updateCompany(CompanyDTO dto) {
        Optional<Company> company = repository.findById(dto.getId());
        if (company.isEmpty()) {
            throw new RuntimeException("Empresa nao encontrado");
        }
        company.get().cloneFromDTO(dto);

        repository.save(company.get());
        return CompanyDTO.toDTO(company.get());
    }

    @Override
    public List<CompanyDTO> findAll() {
        return repository.findAll().stream().map(CompanyDTO::toDTO).toList();
    }
}
