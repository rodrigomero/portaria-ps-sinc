package com.mero.portaria.domain.service.impl;

import com.mero.portaria.domain.model.InspectionDetails;
import com.mero.portaria.domain.model.dto.InspectionDetailsDTO;
import com.mero.portaria.domain.repository.InspectionDetailsRepository;
import com.mero.portaria.domain.service.InspectionDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InspectionDetailsServiceImpl implements InspectionDetailsService {

    private final InspectionDetailsRepository repository;

    @Override
    public InspectionDetailsDTO findById(Integer id) {

        return  repository.findById(id)
                .map(InspectionDetailsDTO::toDTO)
                .orElseThrow(() -> new RuntimeException("Nenhuma empresa encontrada para o ID informado"));
    }

    @Override
    public InspectionDetailsDTO saveInspectionDetails(InspectionDetailsDTO dto) {
        if (dto.getId() != null) {
            return updateInspectionDetails(dto);
        }
        InspectionDetails entity = dto.toEntity();
        repository.save(entity);
        dto.setId(entity.getId());
        return dto;
    }

    private InspectionDetailsDTO updateInspectionDetails(InspectionDetailsDTO dto) {
        Optional<InspectionDetails> inspectionDetails = repository.findById(dto.getId());
        if (inspectionDetails.isEmpty()) {
            throw new RuntimeException("Empresa nao encontrado");
        }
        inspectionDetails.get().cloneFromDTO(dto);

        repository.save(inspectionDetails.get());
        return InspectionDetailsDTO.toDTO(inspectionDetails.get());
    }

    @Override
    public List<InspectionDetailsDTO> findAll() {
        return repository.findAll().stream().map(InspectionDetailsDTO::toDTO).toList();
    }
}
