package com.amurfu.tienda.data.dto;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@Validated
public class SubCategoryDTO {

    private Integer idSubCategory;

    @Size(min = 2, message = "El nombre es muy pequeño")
    @Size(max = 150, message = "El nombre es demasiado grande")
    @NotNull(message = "El nombre de la subcategoría es obligatorio")
    @NotBlank(message = "El nombre de la subcategoría es obligatorio")
    private String nameSubCategory;

    @NotNull(message = "La categoría debe ser obligatoría")
    private Integer idCategory;

}
