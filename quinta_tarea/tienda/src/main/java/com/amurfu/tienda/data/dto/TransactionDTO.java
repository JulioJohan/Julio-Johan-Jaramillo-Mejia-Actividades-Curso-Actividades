package com.amurfu.tienda.data.dto;


import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Validated
public class TransactionDTO {
    private Integer idTransaction;

    @Max(value = 100000000,message = "Ingresa un usuario valido")
    @Size(min = 1,max = 100,message = "Ingresa un usuario valido")
    @NotNull(message = "Debe ingresar un usuario")
    @Positive(message = "Debe ingresar un usuario valido")
    private Integer idUser;
    @Max(value = 100000,message = "Ingresa un usuario valido")
    @Size(min = 1,max = 100,message = "Ingresa un usuario valido")
    @NotNull(message = "Debe ingresar una forma de pago")
    @Positive(message = "Debe ingresar una forma de pago valida")
    private Integer idFormPayment;

    @Positive(message = "Debe ingresar un valor positivo ")
    @NotNull(message = "El total es obligatorio")
    private BigDecimal total;

    private Date date;

    @Valid
    private List<ProductAddDTO> products;

}
