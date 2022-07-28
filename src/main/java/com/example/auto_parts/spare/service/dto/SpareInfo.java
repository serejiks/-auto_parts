package com.example.auto_parts.spare.service.dto;

import com.example.auto_parts.Category;
import com.example.auto_parts.model.Model;
import com.example.auto_parts.spare.Spare;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class SpareInfo {
    private final Long vendorCode;
    private final String name;
    private final Category category;
    private final Set<Long> modelsId;

    public SpareInfo(Spare spare) {
        this.vendorCode = spare.getVendorCode();
        this.name = spare.getName();
        this.category = spare.getCategory();
        this.modelsId = spare.getModels().stream().map(Model::getId).collect(Collectors.toSet());
    }
}
