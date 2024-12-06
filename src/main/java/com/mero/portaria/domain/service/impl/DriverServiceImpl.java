package com.mero.portaria.domain.service.impl;

import com.mero.portaria.domain.model.Driver;
import com.mero.portaria.domain.model.dto.DriverDTO;
import com.mero.portaria.domain.repository.DriverRepository;
import com.mero.portaria.domain.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DriverServiceImpl implements DriverService {

    private final DriverRepository repository;

    @Override
    public DriverDTO findById(Integer id) {

        return repository.findById(id)
                .map(DriverDTO::toDTO)
                .orElseThrow(() -> new RuntimeException("Nenhuma empresa encontrada para o ID informado"));
    }

    @Override
    public DriverDTO saveDriver(DriverDTO dto) {
        if (dto.getId() != null) {
            return updateDriver(dto);
        }
        Driver entity = dto.toEntity();
        repository.save(entity);
        dto.setId(entity.getId());
        return dto;
    }

    private DriverDTO updateDriver(DriverDTO dto) {
        Optional<Driver> driver = repository.findById(dto.getId());
        if (driver.isEmpty()) {
            throw new RuntimeException("Empresa nao encontrado");
        }
        driver.get().cloneFromDTO(dto);

        repository.save(driver.get());
        return DriverDTO.toDTO(driver.get());
    }

    @Override
    public List<DriverDTO> findAll() {
        return repository.findAll().stream().map(DriverDTO::toDTO).toList();
    }
}
