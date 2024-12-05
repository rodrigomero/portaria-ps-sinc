package com.mero.portaria.domain.model.enums;

public enum StatusEnum {

    DISPONIVEL(0, "Disponivel"),
    SERVICO(1, "Em Serviço"),
    INDISPONIVEL(2, "Indisponivel"),
    MANUTENCAO(3, "Manutenção");

    private final int code;
    private final String status;

    StatusEnum(int code, String status) {
        this.code = code;
        this.status = status;
    }

    public static StatusEnum getByCode(int code) {
        for (StatusEnum status : StatusEnum.values()) {
            if (status.getCode() == code) {
                return status;
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }
}
