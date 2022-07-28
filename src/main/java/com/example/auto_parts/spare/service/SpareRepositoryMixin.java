package com.example.auto_parts.spare.service;

import com.example.auto_parts.spare.Spare;
import com.example.auto_parts.spare.service.dto.SpareFilterReqt;

import java.util.List;

public interface SpareRepositoryMixin {
    public List<Spare> search_spare(SpareFilterReqt body);
}
