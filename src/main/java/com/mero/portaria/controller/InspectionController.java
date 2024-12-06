package com.mero.portaria.controller;

import com.mero.portaria.domain.model.dto.InspectionDTO;
import com.mero.portaria.domain.service.InspectionService;
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
@RequestMapping("/inspection")
@CrossOrigin(origins = "*")
public class InspectionController {

    private final InspectionService service;

    @GetMapping("")
    public List<InspectionDTO> getAllInspections() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public InspectionDTO getInspectionById(@PathVariable @NotNull(message = "Id não pode ser nulo.") Integer id) {
        return service.findById(id);
    }

    @PostMapping("/save")
    public InspectionDTO saveInspection(@RequestBody @Valid InspectionDTO dto) {

        return service.saveInspection(dto);
    }

}
