package com.mero.portaria.domain.model.enums;

public enum CarTypeEnum {

    COMUM(0, "Comum"),
    CARGA(1, "Carga"),
    PREMIUM(2, "Premium");

    private final int code;
    private final String type;

    CarTypeEnum(int code, String type) {
        this.code = code;
        this.type = type;
    }

    public static CarTypeEnum getByCode(int code) {
        for (CarTypeEnum status : CarTypeEnum.values()) {
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
