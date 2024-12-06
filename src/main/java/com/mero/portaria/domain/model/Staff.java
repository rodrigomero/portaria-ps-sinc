package com.mero.portaria.domain.model;


import com.mero.portaria.domain.model.dto.StaffDTO;
import com.mero.portaria.domain.model.enums.RoleEnum;
import com.mero.portaria.domain.utils.UtilReflection;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Staff {

    private Integer id;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    private RoleEnum role;

    @NotBlank
    private String name;

    public void cloneFromDTO(StaffDTO staffDTO) {
        String[] ignoredProperties = UtilReflection.getIgnoredProperties(staffDTO);
        BeanUtils.copyProperties(staffDTO, this, ignoredProperties);
    }
}
