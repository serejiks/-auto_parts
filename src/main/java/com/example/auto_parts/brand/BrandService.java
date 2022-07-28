package com.example.auto_parts.brand;

import com.example.auto_parts.brand.dto.BrandInfo;
import com.example.auto_parts.brand.dto.BrandSaveReqt;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Validated
@AllArgsConstructor
public class BrandService {
    BrandRepository brandRepository;

    public Brand findById(Long id) {
        return brandRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Марка " + id + " не найдена"));
    }

    public Brand findByName(String name) {
        return brandRepository.findByName(name);
    }

    public List<BrandInfo> load() {
        var entity  = brandRepository.findAll();
        return entity.stream().map(BrandInfo::new).collect(Collectors.toList());
    }

    public BrandInfo load(@NonNull Long id) {
        var entity  = findById(id);
        return new BrandInfo(entity);
    }

    public Long save(@Valid @NonNull BrandSaveReqt body) {
        if(brandRepository.findByName(body.getName()) != null) {
           throw new RuntimeException("Марка " + body.getName() + " уже существует");
        }
//        brandRepository.findByName(body.getName());
        var entity = new Brand();
        entity.setName(body.getName());
        brandRepository.save(entity);
        return entity.getId();
    }
}
