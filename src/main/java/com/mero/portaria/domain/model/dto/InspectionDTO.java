package com.mero.portaria.domain.model.dto;

import com.mero.portaria.domain.model.Inspection;
import com.mero.portaria.domain.model.enums.InspectionTypeEnum;
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
public class InspectionDTO {

    private Integer id;

    @NotNull
    private Integer carId;

    @NotNull
    private Integer driverId;

    @NotNull
    private InspectionTypeEnum type;

    private LocalDateTime date;

    private Integer inspectorId;

    public static InspectionDTO toDTO(Inspection inspection) {
        InspectionDTO dto = new InspectionDTO();
        BeanUtils.copyProperties(inspection, dto);
        return dto;
    }

    public Inspection toEntity() {
        Inspection inspection = new Inspection();
        BeanUtils.copyProperties(this, inspection);
        return inspection;
    }
}
