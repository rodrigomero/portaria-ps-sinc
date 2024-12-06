package com.mero.portaria.domain.model.dto;

import com.mero.portaria.domain.model.Driver;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
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
public class CreateDriverDTO {

    private Integer id;

    @NotNull
    private Integer companyId;

    @NotNull
    private Integer age;

    @NotEmpty
    private String cnh;

    @NotEmpty
    private String name;

    @Email
    @NotEmpty
    private String email;

    @NotEmpty
    private String password;


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
