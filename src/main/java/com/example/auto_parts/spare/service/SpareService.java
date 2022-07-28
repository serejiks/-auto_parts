package com.example.auto_parts.spare.service;

import com.example.auto_parts.model.Model;
import com.example.auto_parts.model.ModelService;
import com.example.auto_parts.spare.Spare;
import com.example.auto_parts.spare.service.dto.*;
import com.example.auto_parts.spare.service.mappers.SpareMapper;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.auto_parts.spare.service.mappers.SpareMapper.INSTANCE;

@Service
@AllArgsConstructor
public class SpareService {
    private final SpareRepository spareRepository;
    private final ModelService modelService;

    private Spare findById(Long id) {
        return spareRepository.findById(id).orElseThrow(() -> new RuntimeException("Запчасть " + id + " не найдена"));
    }

    public SpareInfo load(Long id) {
        var entity = findById(id);
        return new SpareInfo(entity);
    }

    public List<SpareInfo> load() {
        var list = spareRepository.findAll();
        return list.stream().map(SpareInfo::new).collect(Collectors.toList());
    }

    public List<SpareInfo> searchSpare(SpareFilterReqt body) {
        return spareRepository.search_spare(body).stream().map(SpareInfo::new).toList();
    }

    public Long save(@Valid @NonNull SaveSpareReqt body) {
        if (spareRepository.findById(body.getVendorCode()).isPresent()) {
            throw new RuntimeException("Запчасть " + body.getVendorCode() + " уже существет");
        }
        Spare entity = new Spare();
        entity.setVendorCode(body.getVendorCode());
        entity.setName(body.getName());
        entity.setModels(new HashSet<>(modelService.findByIds(body.getModels())));
        entity.setCategory(body.getCategory());

        spareRepository.save(entity);

        return entity.getVendorCode();
    }

    public Long patch(Long id, @Valid @NonNull SparePatchReqt body) {
        Spare entity = findById(id);
        entity.getModels().forEach(System.out::println);
        SpareMapper.INSTANCE.updateModel(body, entity);
        spareRepository.save(entity);
        return entity.getVendorCode();
    }

    public void delete(Long id) {
        spareRepository.deleteById(id);
    }

    public Long addModel(Long id, SpareAddModel body) {
        Spare entity = findById(id);

        List<Model>  models = modelService.findByIds(body.getModels());
        models.forEach(model -> entity.getModels().add(model));
        spareRepository.save(entity);
        return id;
    }
}
