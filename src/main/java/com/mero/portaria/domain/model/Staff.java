package com.mero.portaria.domain.model;


import com.mero.portaria.domain.model.enums.RoleEnum;
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

    public static Staff toDTO(Staff staff) {
        Staff dto = new Staff();
        BeanUtils.copyProperties(staff, dto);
        return dto;
    }

    public Staff toEntity() {
        Staff staff = new Staff();
        BeanUtils.copyProperties(this, staff);
        return staff;
    }
}
