package com.example.auto_parts.spare;

import com.example.auto_parts.Category;
import com.example.auto_parts.model.Model;
import com.vladmihalcea.hibernate.type.array.LongArrayType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "t_spare")


// Поиск запчасти по артикулу и/или наименованию и/или марке и/или модели и/или категории
@NamedStoredProcedureQuery(
        name = "search_spare",
        procedureName = "public.search_spare",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, type = void.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, type = Long.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class)
        },
        resultClasses = { Spare.class }
)
public class Spare {
    @Id
    @Column(nullable = false)
    private Long vendorCode;

    @Column(nullable = false)
    private String name;

//    @ManyToOne
//    @JoinColumn(name = "model_id")
//    private Model model;
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "t_spare_models",
            joinColumns = @JoinColumn(name = "spare_id"),
            inverseJoinColumns = @JoinColumn(name = "model_id")
    )
    @Column(nullable = false)
    private Set<Model> models = new HashSet<>();

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;

}
