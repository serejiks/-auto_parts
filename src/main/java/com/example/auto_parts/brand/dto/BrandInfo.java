package com.example.auto_parts.brand.dto;

import com.example.auto_parts.brand.Brand;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class BrandInfo {
    private final Long id;

    private final String name;

    public BrandInfo(Brand brand) {
        this.id = brand.getId();
        this.name = brand.getName();
    }
}
