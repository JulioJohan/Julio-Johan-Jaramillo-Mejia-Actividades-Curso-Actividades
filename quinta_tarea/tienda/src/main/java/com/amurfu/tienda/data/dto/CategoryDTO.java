package com.amurfu.tienda.data.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Validated
@Getter
@Setter
public class CategoryDTO {

    private Integer idCategory;

    @Size(min = 2, message = "El nombre es muy pequeño")
    @Size(max = 150, message = "El nombre es demasiado grande")
    @NotNull(message = "El nombre de la subcategoría es obligatorio")
    @NotBlank(message = "El nombre de la subcategoría es obligatorio")
    private String nameCategory;

}
