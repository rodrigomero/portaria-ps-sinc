package com.mero.portaria.domain.service.impl;

import com.mero.portaria.domain.model.Staff;
import com.mero.portaria.domain.model.dto.LoginDTO;
import com.mero.portaria.domain.model.dto.StaffDTO;
import com.mero.portaria.domain.repository.StaffRepository;
import com.mero.portaria.domain.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StaffServiceImpl implements StaffService {

    private final StaffRepository repository;

    @Override
    public StaffDTO findById(Integer id) {

        return repository.findById(id)
                .map(StaffDTO::toDTO)
                .orElseThrow(() -> new RuntimeException("Nenhuma empresa encontrada para o ID informado"));
    }

    @Override
    public StaffDTO findByName(String name) {

        return repository.findByName(name)
                .map(StaffDTO::toDTO)
                .orElseThrow(() -> new RuntimeException("Nenhuma empresa encontrada para o nome informado"));
    }

    @Override
    public StaffDTO saveStaff(StaffDTO dto) {
        if (dto.getId() != null) {
            return updateStaff(dto);
        }
        Staff entity = dto.toEntity();
        repository.save(entity);
        dto.setId(entity.getId());
        return dto;
    }

    private StaffDTO updateStaff(StaffDTO dto) {
        Optional<Staff> staff = repository.findById(dto.getId());
        if (staff.isEmpty()) {
            throw new RuntimeException("Empresa nao encontrado");
        }
        staff.get().cloneFromDTO(dto);

        repository.save(staff.get());
        return StaffDTO.toDTO(staff.get());
    }

    @Override
    public List<StaffDTO> findAll() {
        return repository.findAll().stream().map(StaffDTO::toDTO).toList();
    }

    @Override
    public Staff getAttachedById(Integer id) {
        Optional<Staff> staff = repository.findById(id);
        if (staff.isEmpty()) {
            throw new RuntimeException("Staff nao encontrado");
        }
        return staff.get();

    }

    @Override
    public StaffDTO login(LoginDTO dto) {
        StaffDTO staff = findByEmail(dto.getEmail());

        return staff.getPassword().equals(dto.getPassword()) ? staff : null;
    }

    private StaffDTO findByEmail(String email) {
        return repository.findByEmail(email)
                .map(StaffDTO::toDTO)
                .orElseThrow(() -> new RuntimeException("Nenhuma conta encontrada para o email informado"));
    }
}
