package com.mero.portaria.domain.service.impl;

import com.mero.portaria.domain.model.Inspection;
import com.mero.portaria.domain.model.InspectionDetails;
import com.mero.portaria.domain.model.dto.CreateInspectionDTO;
import com.mero.portaria.domain.model.dto.InspectionDTO;
import com.mero.portaria.domain.repository.InspectionRepository;
import com.mero.portaria.domain.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InspectionServiceImpl implements InspectionService {

    private final InspectionRepository repository;
    private final InspectionDetailsService inspectionDetailsService;
    private final StaffService staffService;
    private final CarService carService;
    private final DriverService driverService;

    @Override
    public InspectionDTO findById(Integer id) {

        return repository.findById(id)
                .map(InspectionDTO::toDTO)
                .orElseThrow(() -> new RuntimeException("Nenhuma empresa encontrada para o ID informado"));
    }

    @Override
    public InspectionDTO saveInspection(CreateInspectionDTO dto) {
        if (dto.getId() != null) {
            return updateInspection(dto);
        }

        InspectionDetails details = inspectionDetailsService.saveInspectionDetails(dto.getInspectionDetails());

        Inspection entity = dto.toEntity();
        entity.setInspectionDetails(details);
        entity.setStaff(staffService.getAttachedById(dto.getInspectorId()));
        entity.setType(dto.getType());
        entity.setCar(carService.getAttachedById(dto.getCarId()));
        entity.setDriver(driverService.getAttachedById(dto.getDriverId()));
        entity.setDate(LocalDateTime.now());
        Inspection savedEntity = repository.save(entity);

        return InspectionDTO.toDTO(savedEntity);
    }

    private InspectionDTO updateInspection(CreateInspectionDTO dto) {
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
