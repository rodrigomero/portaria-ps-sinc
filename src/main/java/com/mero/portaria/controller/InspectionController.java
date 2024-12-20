package com.mero.portaria.controller;

import com.mero.portaria.domain.model.dto.CreateInspectionDTO;
import com.mero.portaria.domain.model.dto.InspectionDTO;
import com.mero.portaria.domain.service.InspectionService;
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
    public InspectionDTO saveInspection(@RequestBody CreateInspectionDTO dto) {

        return service.saveInspection(dto);
    }

}
