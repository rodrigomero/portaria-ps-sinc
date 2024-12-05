package com.mero.portaria.domain.model.enums;

public enum RoleEnum {

    INSPETOR(0, "Inspetor"),
    MOTORISTA(1, "Motorista"),
    GERENTE(2, "Gerente");

    private final int code;
    private final String role;

    RoleEnum(int code, String role) {
        this.code = code;
        this.role = role;
    }

    public static RoleEnum getByCode(int code) {
        for (RoleEnum status : RoleEnum.values()) {
            if (status.getCode() == code) {
                return status;
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }

    public String getRole() {
        return role;
    }
}
