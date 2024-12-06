package com.mero.portaria.domain.model;

import com.mero.portaria.domain.model.interfaces.CloneInterface;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "inspection_details")
public class InspectionDetails implements CloneInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Boolean pneus;
    private Boolean rodas;
    private Boolean freioDeMao;
    private Boolean estepe;
    private Boolean freioDePe;
    private Boolean embreagem;
    private Boolean luzesPainel;
    private Boolean buzina;
    private Boolean farolAlto;
    private Boolean farolBaixo;
    private Boolean setas;
    private Boolean luzEmergencia;
    private Boolean luzFreio;
    private Boolean luzRe;
    private Boolean retrovisor;
    private Boolean nivelAgua;
    private Boolean limpadorParabrisa;
    private Boolean oleoMotor;
    private Boolean pintura;
    private Boolean limpeza;
    private Boolean parabrisa;
    private Boolean semRiscos;
    private Boolean semAmassados;
    private Boolean lateralMotorista;
    private Boolean lateralPassageiro;
    private Boolean traseira;
    private Boolean frente;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "inspection_id", referencedColumnName = "id")
    private Inspection inspection;

}
