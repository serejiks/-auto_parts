package com.example.auto_parts.spare.service.mappers;

import com.example.auto_parts.spare.Spare;
import com.example.auto_parts.spare.service.dto.SparePatchReqt;
import com.example.auto_parts.spare.service.dto.SpareUpdateReqt;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface SpareMapper {
    SpareMapper INSTANCE = Mappers.getMapper(SpareMapper.class);
    void updateModel(SpareUpdateReqt updateSpareReqt, @MappingTarget Spare spare);
    void updateModel(SparePatchReqt updateSpareReqt, @MappingTarget Spare spare);
//    Spare updateModel(SparePatchReqt updateSpareReqt);
}
