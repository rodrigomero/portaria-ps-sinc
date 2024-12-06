package com.mero.portaria.domain.model.dto;

import com.mero.portaria.domain.model.InspectionDetails;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InspectionDetailsDTO {

    private Integer id;

    private Integer inspectionId;

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

    public static InspectionDetailsDTO toDTO(InspectionDetails inspectionDetails) {
        InspectionDetailsDTO dto = new InspectionDetailsDTO();
        BeanUtils.copyProperties(inspectionDetails, dto);
        return dto;
    }

    public InspectionDetails toEntity() {
        InspectionDetails inspectionDetails = new InspectionDetails();
        BeanUtils.copyProperties(this, inspectionDetails);
        return inspectionDetails;
    }
}
