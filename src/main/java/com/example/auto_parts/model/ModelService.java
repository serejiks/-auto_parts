package com.example.auto_parts.model;

import com.example.auto_parts.brand.BrandService;
import com.example.auto_parts.model.dto.ModelInfo;
import com.example.auto_parts.model.dto.ModelSaveReqt;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Validated
@AllArgsConstructor
public class ModelService {
    ModelRepository modelRepository;
    BrandService brandService;


    public Model findById(Long id) {
        return modelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Модель" + id + " не найдена"));
    }

    public List<Model> findByIds(Collection<Long> ids) {
        List<Model> models = modelRepository.findAllById(ids);
        if (models.size() != ids.size()) {
            throw new RuntimeException("Возможно, вы патаетесь добавить одну или несколько моделей, которых нет в базе данных");
        }
        return models;
    }

    public List<ModelInfo> load() {
        var entity = modelRepository.findAll();
        return entity.stream().map(ModelInfo::new).collect(Collectors.toList());
    }

    public ModelInfo load(Long id) {
        var entity = findById(id);
        return new ModelInfo(entity);
    }

    public Long save(ModelSaveReqt body) {
        if(modelRepository.findByName(body.getName()) != null) {
            throw new RuntimeException("Модель " + body.getName() + " уже существует");
        }
        var entity = new Model();
        entity.setName(body.getName());
        entity.setBrand(brandService.findById(body.getBrandId()));
        modelRepository.save(entity);
        return entity.getId();
    }
}
