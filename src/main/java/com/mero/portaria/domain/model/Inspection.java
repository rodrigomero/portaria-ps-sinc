package com.mero.portaria.domain.model;


import com.mero.portaria.domain.model.dto.InspectionDTO;
import com.mero.portaria.domain.model.enums.InspectionTypeEnum;
import com.mero.portaria.domain.utils.UtilReflection;
import jakarta.validation.constraints.NotNull;
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
public class Inspection {

    private Integer id;

    @NotNull
    private Integer carId;

    @NotNull
    private Integer driverId;

    @NotNull
    private InspectionTypeEnum type;

    private LocalDateTime date;

    private Integer inspectorId;

    public void cloneFromDTO(InspectionDTO inspectionDTO) {
        String[] ignoredProperties = UtilReflection.getIgnoredProperties(inspectionDTO);
        BeanUtils.copyProperties(inspectionDTO, this, ignoredProperties);
    }
}
