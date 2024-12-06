package com.mero.portaria.controller;

import com.mero.portaria.domain.model.dto.CompanyDTO;
import com.mero.portaria.domain.service.CompanyService;
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
@RequestMapping("/company")
@CrossOrigin(origins = "*")
public class CompanyController {

    private final CompanyService service;

    @GetMapping("")
    public List<CompanyDTO> getAllCompanys() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public CompanyDTO getCompanyById(@PathVariable @NotNull(message = "Id não pode ser nulo.") Integer id) {
        return service.findById(id);
    }

    @GetMapping("/{name}")
    public CompanyDTO getCompanyByName(@PathVariable @NotEmpty(message = "Nome não pode ser nulo.") String name) {
        return service.findByName(name);
    }

    @PostMapping("/save")
    public CompanyDTO saveCompany(@RequestBody @Valid CompanyDTO dto) {

        return service.saveCompany(dto);
    }

}
