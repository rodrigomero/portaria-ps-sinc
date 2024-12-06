package com.mero.portaria.domain.service.impl;

import com.mero.portaria.domain.model.Driver;
import com.mero.portaria.domain.model.dto.CreateDriverDTO;
import com.mero.portaria.domain.model.dto.DriverDTO;
import com.mero.portaria.domain.model.dto.StaffDTO;
import com.mero.portaria.domain.model.enums.RoleEnum;
import com.mero.portaria.domain.repository.DriverRepository;
import com.mero.portaria.domain.service.CompanyService;
import com.mero.portaria.domain.service.DriverService;
import com.mero.portaria.domain.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DriverServiceImpl implements DriverService {

    private final DriverRepository repository;
    private final StaffService staffService;
    private final CompanyService companyService;

    @Override
    public DriverDTO findById(Integer id) {

        return repository.findById(id)
                .map(DriverDTO::toDTO)
                .orElseThrow(() -> new RuntimeException("Nenhum motorista encontrada para o ID informado"));
    }

    @Transactional
    @Override
    public DriverDTO saveDriver(CreateDriverDTO dto) {
        if (dto.getId() != null) {
            return updateDriver(dto);
        }
        StaffDTO staffDTO = new StaffDTO();
        staffDTO.setName(dto.getName());
        staffDTO.setEmail(dto.getEmail());
        staffDTO.setPassword(dto.getPassword());
        staffDTO.setRole(RoleEnum.MOTORISTA);

        Driver driver = new Driver();
        driver.setCompany(companyService.getAttachedById(dto.getCompanyId()));
        driver.setStaff(staffService.getAttachedById(staffService.saveStaff(staffDTO).getId()));
        driver.setAge(dto.getAge());
        driver.setCnh(dto.getCnh());
        driver.setActiveCar(null);

        return DriverDTO.toDTO(repository.save(driver));
    }

    private DriverDTO updateDriver(CreateDriverDTO dto) {
        Optional<Driver> driver = repository.findById(dto.getId());
        if (driver.isEmpty()) {
            throw new RuntimeException("Motorista nao encontrado");
        }
        driver.get().cloneFromDTO(dto);

        repository.save(driver.get());
        return CreateDriverDTO.toDTO(driver.get());
    }

    @Override
    public List<DriverDTO> findAll() {
        return repository.findAll().stream().map(DriverDTO::toDTO).toList();
    }

    @Override
    public Driver getAttachedById(Integer id) {
        Optional<Driver> driver = repository.findById(id);
        if (driver.isEmpty()) {
            throw new RuntimeException("Driver nao encontrado");
        }
        return driver.get();

    }
}
