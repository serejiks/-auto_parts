package com.example.auto_parts.util;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SimpleResponse<T> {
    private final T result;

    public static final SimpleResponse<?> EMPTY = new SimpleResponse<>(null);
}
