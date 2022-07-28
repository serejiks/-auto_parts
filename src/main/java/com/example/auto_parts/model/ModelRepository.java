package com.example.auto_parts.model;

import com.example.auto_parts.brand.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Long> {
    Model findByName(String name);
}
