package com.mero.portaria.domain.model.dto;

import com.mero.portaria.domain.model.Driver;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DriverDTO {

    private Integer id;

    private Integer companyId;

    private Integer age;

    @NotEmpty
    private String cnh;

    private Integer staffId;

    private Integer activeCar;

    public static DriverDTO toDTO(Driver driver) {
        DriverDTO dto = new DriverDTO();
        BeanUtils.copyProperties(driver, dto);
        return dto;
    }

    public Driver toEntity() {
        Driver driver = new Driver();
        BeanUtils.copyProperties(this, driver);
        return driver;
    }
}
