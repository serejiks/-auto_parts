package com.example.auto_parts.brand.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class BrandSaveReqt {
    @NotBlank
    private String name;
}
