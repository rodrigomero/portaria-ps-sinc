package com.mero.portaria.controller;

import com.mero.portaria.domain.model.dto.StaffDTO;
import com.mero.portaria.domain.service.StaffService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/staff")
@CrossOrigin(origins = "*")
public class StaffController {

    private final StaffService service;

    @GetMapping("")
    public List<StaffDTO> getAllStaffs() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public StaffDTO getStaffById(@PathVariable @NotNull(message = "Id não pode ser nulo.") Integer id) {
        return service.findById(id);
    }

    @GetMapping("/{name}")
    public StaffDTO getStaffByName(@PathVariable @NotEmpty(message = "Nome não pode ser nulo.") String name) {
        return service.findByName(name);
    }

    @PostMapping("/save")
    public StaffDTO saveStaff(@RequestBody @Valid StaffDTO dto) {

        return service.saveStaff(dto);
    }

}
