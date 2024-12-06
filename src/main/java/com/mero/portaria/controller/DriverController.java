package com.mero.portaria.controller;

import com.mero.portaria.domain.model.dto.DriverDTO;
import com.mero.portaria.domain.service.DriverService;
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
@RequestMapping("/driver")
@CrossOrigin(origins = "*")
public class DriverController {

    private final DriverService service;

    @GetMapping("")
    public List<DriverDTO> getAllDrivers() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public DriverDTO getDriverById(@PathVariable @NotNull(message = "Id não pode ser nulo.") Integer id) {
        return service.findById(id);
    }

    @PostMapping("/save")
    public DriverDTO saveDriver(@RequestBody @Valid DriverDTO dto) {

        return service.saveDriver(dto);
    }

}
