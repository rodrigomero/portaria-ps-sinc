package com.mero.portaria.domain.model;


import com.mero.portaria.domain.model.enums.RoleEnum;
import com.mero.portaria.domain.model.interfaces.CloneInterface;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "staff")
public class Staff implements CloneInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Email
    @NotEmpty
    private String email;

    @NotEmpty
    private String password;

    @NotNull
    private RoleEnum role;

    @NotEmpty
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "driver_id", referencedColumnName = "id")
    private Driver driver;

    @OneToMany(mappedBy = "staff", fetch = FetchType.LAZY)
    private List<Inspection> inspections;

}
