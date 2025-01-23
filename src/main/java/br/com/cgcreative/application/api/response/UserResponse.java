package br.com.cgcreative.application.api.response;

import br.com.cgcreative.domain.enums.RolesEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private String name;
    private RolesEnum role;
}
