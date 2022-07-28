package com.example.auto_parts.brand.api;

import com.example.auto_parts.brand.BrandService;
import com.example.auto_parts.brand.dto.BrandInfo;
import com.example.auto_parts.brand.dto.BrandSaveReqt;
import com.example.auto_parts.util.SimpleResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/brand")
public class BrandApi {
    BrandService brandService;

    @GetMapping()
    public SimpleResponse<List<BrandInfo>> load() {
        var resp = brandService.load();
        return new SimpleResponse<>(resp);
    }

    @GetMapping("{id}")
    public SimpleResponse<BrandInfo> load(@PathVariable Long id) {
        var resp = brandService.load(id);
        return new SimpleResponse<>(resp);
    }

    @PostMapping
    public SimpleResponse<Long> save(@RequestBody BrandSaveReqt body){
        var resp = brandService.save(body);
        return new SimpleResponse<>(resp);
    }
}
