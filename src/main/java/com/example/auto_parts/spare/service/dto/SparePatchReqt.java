package com.example.auto_parts.spare.service.dto;

import com.example.auto_parts.Category;
import com.example.auto_parts.model.Model;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
public class SparePatchReqt {
    private String name;
    private Category category;
//    private Set<Long> models = new HashSet<>();
    private Set<Model> models;
}
