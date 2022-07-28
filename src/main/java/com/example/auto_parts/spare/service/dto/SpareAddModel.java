package com.example.auto_parts.spare.service.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class SpareAddModel {
    @NotBlank
    private Set<Long> models = new HashSet<>();
}
