package com.example.auto_parts;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@RequiredArgsConstructor
public enum Category {
    BODY("BODY"),
    ENGINE("ENGINE"),
    CHASSIS("CHASSIS"),
    BREAK("BREAK"),
    SALON("SALON")
    ;

    private final String name;
}
