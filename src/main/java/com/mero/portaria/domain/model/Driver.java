package com.mero.portaria.domain.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Driver {

    private Integer id;

    @NotNull
    private Integer companyId;

    private Integer age;

    @NotBlank
    private String cnh;

    private Integer staffId;

    private Integer activeCar;

    public static Driver toDTO(Driver driver) {
        Driver dto = new Driver();
        BeanUtils.copyProperties(driver, dto);
        return dto;
    }

    public Driver toEntity() {
        Driver driver = new Driver();
        BeanUtils.copyProperties(this, driver);
        return driver;
    }
}
