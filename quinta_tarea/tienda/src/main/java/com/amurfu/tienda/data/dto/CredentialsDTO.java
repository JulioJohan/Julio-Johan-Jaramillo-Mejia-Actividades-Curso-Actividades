package com.amurfu.tienda.data.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@Validated
public class CredentialsDTO {


    @NotNull(message = "Debe ingresar un correo valido")
    private String email;

    @NotNull(message = "Debes de ingresar una contraseña valida")
    private String password;

}
