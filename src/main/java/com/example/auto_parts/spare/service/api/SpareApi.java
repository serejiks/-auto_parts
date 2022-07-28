package com.example.auto_parts.spare.service.api;

import com.example.auto_parts.spare.Spare;
import com.example.auto_parts.spare.service.SpareService;
import com.example.auto_parts.spare.service.dto.*;
import com.example.auto_parts.util.SimpleResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/spare")
public class SpareApi {
    private final SpareService spareService;

    @GetMapping()
    public SimpleResponse<List<SpareInfo>> load() {
        var resp = spareService.load();
        return new SimpleResponse<>(resp);
    }

    @GetMapping("{id}")
    public SimpleResponse<SpareInfo> load(@PathVariable Long id) {
        var resp = spareService.load(id);
        return new SimpleResponse<>(resp);
    }

    @PostMapping("search")
    public SimpleResponse<List<SpareInfo>> search(@RequestBody SpareFilterReqt body) {
        var resp = spareService.searchSpare(body);
        return new SimpleResponse<>(resp);
    }

    @PostMapping()
    public SimpleResponse<Long> save(@RequestBody SaveSpareReqt body) {
        var resp = spareService.save(body);
        return new SimpleResponse<>(resp);
    }

//    @PutMapping("{id}")
//    public SimpleResponse<Long> save(@PathVariable Long id, @RequestBody SpareUpdateReqt body) {
//        var resp = spareService.update(id, body);
//        return new SimpleResponse<>(resp);
//    }

    @PutMapping("{id}")
    public SimpleResponse<Long> update(@PathVariable Long id, @RequestBody SparePatchReqt body) {
        var resp = spareService.patch(id, body);
        return new SimpleResponse<>(resp);
    }

    @PutMapping("{id}/addModel")
    public SimpleResponse<Long> addModels(@PathVariable Long id, @RequestBody SpareAddModel body) {
        var resp = spareService.addModel(id, body);
        return new SimpleResponse<>(resp);
    }

    @DeleteMapping("{id}")
    private SimpleResponse<?> delete(@PathVariable("id") Long id) {
        spareService.delete(id);
        return SimpleResponse.EMPTY;
    }

}
