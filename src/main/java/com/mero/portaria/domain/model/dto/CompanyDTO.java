package com.mero.portaria.domain.model.dto;

import com.mero.portaria.domain.model.Company;
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
public class CompanyDTO {

    private Integer id;
    @NotBlank
    private String name;

    private String address;

    private String phone;

    private String email;

    private String cnpj;

    public static CompanyDTO toDTO(Company company) {
        CompanyDTO dto = new CompanyDTO();
        BeanUtils.copyProperties(company, dto);
        return dto;
    }

    public Company toEntity() {
        Company company = new Company();
        BeanUtils.copyProperties(this, company);
        return company;
    }
}
