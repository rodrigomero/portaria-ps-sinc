package com.mero.portaria.domain.model.dto;

import com.mero.portaria.domain.model.Car;
import com.mero.portaria.domain.model.enums.CarTypeEnum;
import com.mero.portaria.domain.model.enums.StatusEnum;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarDTO {

    private Integer id;

    @NotBlank
    private CarTypeEnum type;

    @NotBlank
    private String brand;

    @NotBlank
    private String model;

    private Integer year;

    private String color;

    @NotBlank
    private String plate;

    private LocalDateTime lastMaintenance;

    private StatusEnum status;

    public static CarDTO toDTO(Car car) {
        CarDTO dto = new CarDTO();
        BeanUtils.copyProperties(car, dto);
        return dto;
    }

    public Car toEntity() {
        Car car = new Car();
        BeanUtils.copyProperties(this, car);
        return car;
    }
}
