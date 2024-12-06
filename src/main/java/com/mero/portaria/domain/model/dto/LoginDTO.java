package com.mero.portaria.domain.model.dto;

import com.mero.portaria.domain.model.Staff;
import jakarta.validation.constraints.Email;
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
public class LoginDTO {

    @Email
    @NotEmpty
    private String email;

    @NotEmpty
    private String password;

    public static LoginDTO toDTO(Staff staff) {
        LoginDTO dto = new LoginDTO();
        BeanUtils.copyProperties(staff, dto);
        return dto;
    }

    public Staff toEntity() {
        Staff staff = new Staff();
        BeanUtils.copyProperties(this, staff);
        return staff;
    }
}
