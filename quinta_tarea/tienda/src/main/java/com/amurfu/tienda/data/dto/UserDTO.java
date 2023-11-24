package com.amurfu.tienda.data.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@Validated
public class UserDTO {

    private Integer idUser;

    @Size(min = 2, message = "El nombre es muy pequeño")
    @Size(max = 50, message = "El nombre es demasiado grande")
    @NotNull(message = "El primer nombre es obligatorio")
    @NotBlank(message = "El primer nombre es obligatorio")
    private String firstName;

    @Size(min = 2, message = "El segundo nombre es muy pequeño")
    @Size(max = 50, message = "El segundo nombre es demasiado grande")
    @NotBlank(message = "El segundo nombre debe ser uno valido")
    private String middleName;

    @Size(min = 2, message = "El apellido es muy pequeño")
    @Size(max = 50, message = "El apellido es demasiado pequeño")
    @NotNull(message = "El primer apellido es obligatorio")
    @NotBlank(message = "El primer apellido es obligatorio")
    private String lastName;

    @Size(min = 2, message = "El segundo apellido es muy pequeño")
    @Size(max = 50, message = "El segundo apellido es demasiado pequeño")
    @NotNull(message = "El segundo apellido es obligatorio")
    @NotBlank(message = "El segundo apellido es obligatorio")
    private String secondLastName;

    @Size(min = 12, message = "El correo electronico es muy pequeño")
    @Size(max = 200, message = "El correo electronico es muy grande")
    @NotBlank(message = "El correo electronico es obligatorio")
    @Email(message = "El correo electronico debe ser uno valido ")
    private String email;

//    @NotBlank(message = "La contraseña es necesaria")
    @NotNull(message = "La contraseña es necesaria")
    @Size(min = 8, message = "La contraseña debe ser minimo de ocho caracteres")
    @Size(max = 200, message = "Se que quieres estar seguro pero tampoco xD, reduce el tamanio de la contraseña")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$",
            message = "La contraseña debe tener al menos un carácter especial, una letra mayúscula y un número")
    private String password;

    // Esta propiedad puede ser null o un número de exactamente 10 dígitos
    @Min(value = 1000000000, message = "El número de teléfono debe tener exactamente 10 dígitos")
    @Max(value = 9999999999L, message = "El número de teléfono debe tener exactamente 10 dígitos")
    private Long phone;

    private String avatar;

}
