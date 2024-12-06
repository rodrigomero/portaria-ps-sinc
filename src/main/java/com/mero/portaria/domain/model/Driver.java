package com.mero.portaria.domain.model;

import com.mero.portaria.domain.model.dto.DriverDTO;
import com.mero.portaria.domain.utils.UtilReflection;
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

    public void cloneFromDTO(DriverDTO driverDTO) {
        String[] ignoredProperties = UtilReflection.getIgnoredProperties(driverDTO);
        BeanUtils.copyProperties(driverDTO, this, ignoredProperties);
    }
}
