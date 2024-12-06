package com.mero.portaria.domain.model;

import com.mero.portaria.domain.model.dto.CompanyDTO;
import com.mero.portaria.domain.utils.UtilReflection;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String cnpj;

    private String telephone;

    private String address;

    private String email;

    @OneToMany(mappedBy = "driver", fetch = FetchType.LAZY)
    private List<Driver> drivers;

    public void cloneFromDTO(CompanyDTO companyDTO) {
        String[] ignoredProperties = UtilReflection.getIgnoredProperties(companyDTO);
        BeanUtils.copyProperties(companyDTO, this, ignoredProperties);
    }
}
