package br.com.cgcreative.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RolesEnum {
    ADMIN ("ADMIN_ROLE"),
    USUARIO("USUARIO_ROLE"),
    GERENTE("GERENTE_ROLE");

    private final String role;
}
