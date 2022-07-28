package com.example.auto_parts.spare.service;

import com.example.auto_parts.spare.Spare;
import com.example.auto_parts.spare.service.dto.SpareFilterReqt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SpareRepository extends JpaRepository<Spare, Long>, SpareRepositoryMixin {

}
