package com.example.auto_parts.spare.service.dto;

import com.example.auto_parts.Category;
import com.example.auto_parts.model.Model;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class SaveSpareReqt {
    @NotNull
    private Long vendorCode;
    @NotBlank
    private String name;
    @NotBlank
    private Category category;
    @NotBlank
    private Set<Long> models = new HashSet<>();
}
