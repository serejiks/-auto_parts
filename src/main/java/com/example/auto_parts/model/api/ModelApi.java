package com.example.auto_parts.model.api;

import com.example.auto_parts.model.ModelService;
import com.example.auto_parts.model.dto.ModelInfo;
import com.example.auto_parts.model.dto.ModelSaveReqt;
import com.example.auto_parts.util.SimpleResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/model")
public class ModelApi {
    ModelService modelService;

    @GetMapping()
    public SimpleResponse<List<ModelInfo>> load() {
        var resp = modelService.load();
        return new SimpleResponse<>(resp);
    }

    @GetMapping("{id}")
    public SimpleResponse<ModelInfo> load(@PathVariable Long id) {
        var resp = modelService.load(id);
        return new SimpleResponse<>(resp);
    }

    @PostMapping
    public SimpleResponse<Long> save(@RequestBody ModelSaveReqt body){
        var resp = modelService.save(body);
        return new SimpleResponse<>(resp);
    }
}
