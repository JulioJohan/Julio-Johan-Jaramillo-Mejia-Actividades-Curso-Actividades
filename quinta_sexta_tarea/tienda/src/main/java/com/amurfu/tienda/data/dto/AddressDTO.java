package com.amurfu.tienda.data.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@Validated
public class AddressDTO {


    private Integer idAddress;

    @Size(min = 2, message = "El nombre es muy pequeño")
    @Size(max = 50, message = "El nombre es demasiado grande")
    @NotNull(message = "El primer nombre es obligatorio")
    @NotBlank(message = "El primer nombre es obligatorio")
    private String fullName;


    @Digits(integer = 10,fraction = 0,message = "El numero de telofono solo debe de tener 10 digitos")
    @NotNull(message = "El numero de teléfono es obligatorio")
    @NotBlank(message = "El numero de teléfono es obligatorio")
    private Long phone;

    @NotNull(message = "El codigo postal es obligatorio")
    @NotBlank(message = "El codigo postal es obligatorio")
    private String postalCode;

    @Size(min = 2,message = "El nombre del pais es muy pequeño")
    @Size(max = 60, message = "El nombre del pais es muy grande")
    @NotNull(message = "El pais es obligatorio")
    @NotBlank(message = "El pais es obligatorio")
    private String country;

    @Size(min = 2,message = "El nombre del estado es muy pequeño")
    @Size(max = 60, message = "El nombre del estado es muy grande")
    @NotNull(message = "El estado es obligatorio")
    @NotBlank(message = "El estado es obligatorio")
    private String estate;

    @Size(min = 2,message = "El nombre de la ciudad es muy pequeño")
    @Size(max = 170, message = "El nombre de la ciudad es muy grande")
    @NotNull(message = "El nombre de la ciudad es obligatorio")
    @NotBlank(message = "El nombre de la ciudad es obligatorio")
    private String city;

    @Size(min = 2,message = "El nombre de la calle es muy pequeño")
    @Size(max = 100, message = "El nombre de la calle es muy grande")
    @NotNull(message = "El nombre de la calle  es obligatorio")
    @NotBlank(message = "El nombre de la calle es obligatorio")
    private String street;

    @Size(min = 2,message = "El numero interior es muy pequeño")
    @Size(max = 5, message = "El numero interior es muy grande")
    @NotNull(message = "El numero interior  es obligatorio")
    @NotBlank(message = "El numero interior es obligatorio")
    private String outerNumber;

    private String innerNumber;


    @Size(min = 1,message = "La referencia es muy pequeño")
    @Size(max = 500, message = "La referencia interior es muy grande")
    @NotNull(message = "La referencia es obligatorio")
    @NotBlank(message = "La referencia es obligatorio")
    private String addressReferences;



    @NotNull(message = "El id del usuario es obligatorio")
    @NotBlank(message = "El id del usuario es obligatorio")
    private Integer idUser;
}
