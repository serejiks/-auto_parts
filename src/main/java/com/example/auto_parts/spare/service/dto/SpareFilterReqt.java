package com.example.auto_parts.spare.service.dto;

import com.example.auto_parts.Category;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class SpareFilterReqt {
    private Long vendorCode;
    private String name;
    private Category category;
    private Long modelId;
    private Long brandId;
    private Integer currentPage;
    private Integer showPerPage;
}
