package com.mero.portaria.domain.model;


import com.mero.portaria.domain.model.enums.InspectionTypeEnum;
import com.mero.portaria.domain.model.interfaces.CloneInterface;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
@Table(name = "inspection")
public class Inspection implements CloneInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private InspectionTypeEnum type;

    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private Car car;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "inspection_details_id", referencedColumnName = "id")
    private InspectionDetails inspectionDetails;

    @ManyToOne
    @JoinColumn(name = "driver_id", referencedColumnName = "id")
    private Driver driver;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Staff staff;

}
