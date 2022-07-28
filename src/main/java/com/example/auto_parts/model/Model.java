package com.example.auto_parts.model;

import com.example.auto_parts.brand.Brand;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "t_model")
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @Override
    public String toString() {
        return "Model{" +
                "id=" + id +
                '}';
    }
}
