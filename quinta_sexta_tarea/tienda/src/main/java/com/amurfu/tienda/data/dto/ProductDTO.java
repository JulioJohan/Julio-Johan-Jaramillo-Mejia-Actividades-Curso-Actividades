package com.amurfu.tienda.data.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;

@Getter
@Setter
@Validated
public class ProductDTO {

    private Integer idProduct;

    @Size(min = 5,message = "El nombre del producto es muy pequeño")
    @Size(max = 100,message = "El nombre del producto es muy grande")
    @NotBlank(message = "El nombre del producto es obligatorio")
    @NotNull(message = "El nombre del producto es obligatorio")
    private String nameProduct;

    @Size(min = 5,message = "La descripción del producto es muy pequeño")
    @Size(max = 5000,message = "La descripción del producto es muy grande")
    @NotBlank(message = "La descripción del producto es obligatorio")
    @NotNull(message = "La descripción del producto es obligatorio")
    private String description;

    @Size(min = 5,message = "EL serial del producto es muy pequeño")
    @Size(max = 100,message = "El serial del producto es muy grande")
    @NotBlank(message = "El serial del producto es obligatorio")
    @NotNull(message = "El serial del producto es obligatorio")
    private String serial;

    @Size(min = 1,message = "El estatus del producto es obligatorio")
    @Size(max = 100,message = "El estatus del producto es muy grande")
    @NotBlank(message = "El estatus del producto es obligatorio")
    @NotNull(message = "El estatus del producto es obligatorio")
    private String status;


    @Min(value = 1,message = "El stock es muy pequeño")
    @Max(value = 100000000,message = "El stock es muy grande")
    @NotNull(message = "El stock del producto es obligatorio")
    private Integer stock;

    @Min(value = 1,message = "El precio es muy pequeño")
    @Max(value = 100000000,message = "El precio es muy alto")
    @NotNull(message = "El serial del producto es obligatorio")
    private BigDecimal price;

    @NotNull(message = "La categoría del producto es obligatorio")
    private Integer idCategory;

    @NotNull(message = "La sub categoría del producto es obligatorio")
    private Integer idSubCategory;
}
