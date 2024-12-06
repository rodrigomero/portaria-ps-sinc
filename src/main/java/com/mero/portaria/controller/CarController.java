package com.mero.portaria.controller;

import com.mero.portaria.domain.model.dto.CarDTO;
import com.mero.portaria.domain.service.CarService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/car")
@CrossOrigin(origins = "*")
public class CarController {

    private final CarService service;

    @GetMapping("")
    public List<CarDTO> getAllCars() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public CarDTO getCarById(@PathVariable @NotNull(message = "Id não pode ser nulo.") Integer id) {
        return service.findById(id);
    }

    @PostMapping("/save")
    public CarDTO saveCar(@RequestBody @Valid CarDTO dto) {

        return service.saveCar(dto);
    }

}
