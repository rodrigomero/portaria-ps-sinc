package com.mero.portaria.domain.service.impl;

import com.mero.portaria.domain.model.Inspection;
import com.mero.portaria.domain.model.dto.InspectionDTO;
import com.mero.portaria.domain.repository.InspectionRepository;
import com.mero.portaria.domain.service.InspectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InspectionServiceImpl implements InspectionService {

    private final InspectionRepository repository;

    @Override
    public InspectionDTO findById(Integer id) {

        return  repository.findById(id)
                .map(InspectionDTO::toDTO)
                .orElseThrow(() -> new RuntimeException("Nenhuma empresa encontrada para o ID informado"));
    }
    
    @Override
    public InspectionDTO saveInspection(InspectionDTO dto) {
        if (dto.getId() != null) {
            return updateInspection(dto);
        }
        Inspection entity = dto.toEntity();
        repository.save(entity);
        dto.setId(entity.getId());
        return dto;
    }

    private InspectionDTO updateInspection(InspectionDTO dto) {
        Optional<Inspection> inspection = repository.findById(dto.getId());
        if (inspection.isEmpty()) {
            throw new RuntimeException("Empresa nao encontrado");
        }
        inspection.get().cloneFromDTO(dto);

        repository.save(inspection.get());
        return InspectionDTO.toDTO(inspection.get());
    }

    @Override
    public List<InspectionDTO> findAll() {
        return repository.findAll().stream().map(InspectionDTO::toDTO).toList();
    }
}
