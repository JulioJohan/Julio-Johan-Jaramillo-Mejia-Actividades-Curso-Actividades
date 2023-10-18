package com.amurfu.tienda.data.dto;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;

@Setter
@Getter
@Validated
public class ProductAddDTO {

    @NotNull(message = "Debe ingresar un id de producto valido")
    @Positive(message = "Debe ingresar un id de producto valido")
    private Integer idProduct;
    @NotNull(message = "Debe ingresar una cantidad valida")
    @Positive(message = "Debe ingresar una cantidad valida")
    private Integer quantityProducts;
    private BigDecimal price;
    private BigDecimal total;

}
