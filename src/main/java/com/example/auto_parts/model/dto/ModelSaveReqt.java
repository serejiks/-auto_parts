package com.example.auto_parts.model.dto;


import com.example.auto_parts.brand.Brand;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ModelSaveReqt {
    @NotBlank
    private String name;

    @NotNull
    private Long brandId;
}
