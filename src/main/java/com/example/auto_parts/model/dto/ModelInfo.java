package com.example.auto_parts.model.dto;

import com.example.auto_parts.model.Model;
import lombok.Getter;

@Getter
public class ModelInfo {

    private final Long id;

    private final String name;

    private final String brandName;

    public ModelInfo(Model model){
        this.id  = model.getId();
        this.name  = model.getName();
        this.brandName  = model.getBrand().getName();
    }
}
