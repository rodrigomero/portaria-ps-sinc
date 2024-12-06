package com.mero.portaria.domain.model;


import com.mero.portaria.domain.model.dto.CarDTO;
import com.mero.portaria.domain.model.enums.CarTypeEnum;
import com.mero.portaria.domain.model.enums.StatusEnum;
import com.mero.portaria.domain.utils.UtilReflection;
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
public class Car {

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

    public void cloneFromDTO(CarDTO carDTO) {
        String[] ignoredProperties = UtilReflection.getIgnoredProperties(carDTO);
        BeanUtils.copyProperties(carDTO, this, ignoredProperties);
    }
}
