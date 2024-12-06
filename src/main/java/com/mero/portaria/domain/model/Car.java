package com.mero.portaria.domain.model;


import com.mero.portaria.domain.model.enums.CarTypeEnum;
import com.mero.portaria.domain.model.enums.StatusEnum;
import com.mero.portaria.domain.model.interfaces.CloneInterface;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "car")
public class Car implements CloneInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotEmpty
    private CarTypeEnum type;

    @NotEmpty
    private String brand;

    @NotEmpty
    private String model;

    private Integer releaseYear;

    private String color;

    @NotEmpty
    private String plate;

    private LocalDateTime lastMaintenance;

    private StatusEnum status;

}
