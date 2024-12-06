package com.mero.portaria.domain.service.impl;

import com.mero.portaria.domain.model.Car;
import com.mero.portaria.domain.model.dto.CarDTO;
import com.mero.portaria.domain.repository.CarRepository;
import com.mero.portaria.domain.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository repository;

    @Override
    public CarDTO findById(Integer id) {

        return repository.findById(id)
                .map(CarDTO::toDTO)
                .orElseThrow(() -> new RuntimeException("Nenhuma empresa encontrada para o ID informado"));
    }


    @Override
    public CarDTO saveCar(CarDTO dto) {
        if (dto.getId() != null) {
            return updateCar(dto);
        }
        Car entity = dto.toEntity();
        repository.save(entity);
        dto.setId(entity.getId());
        return dto;
    }

    private CarDTO updateCar(CarDTO dto) {
        Optional<Car> car = repository.findById(dto.getId());
        if (car.isEmpty()) {
            throw new RuntimeException("Empresa nao encontrado");
        }
        car.get().cloneFromDTO(dto);

        repository.save(car.get());
        return CarDTO.toDTO(car.get());
    }

    @Override
    public List<CarDTO> findAll() {
        return repository.findAll().stream().map(CarDTO::toDTO).toList();
    }
}
