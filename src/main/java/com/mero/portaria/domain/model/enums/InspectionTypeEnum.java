package com.mero.portaria.domain.model.enums;

public enum InspectionTypeEnum {

    ENTRADA(0, "Entrada"),
    SAIDA(1, "Saida"),
    ROTINA(2, "Rotina");

    private final int code;
    private final String type;

    InspectionTypeEnum(int code, String type) {
        this.code = code;
        this.type = type;
    }

    public static InspectionTypeEnum getByCode(int code) {
        for (InspectionTypeEnum status : InspectionTypeEnum.values()) {
            if (status.getCode() == code) {
                return status;
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }

    public String getType() {
        return type;
    }
}
