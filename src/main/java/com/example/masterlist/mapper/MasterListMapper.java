package com.example.masterlist.mapper;

import com.example.masterlist.dto.MasterListRequestDto;
import com.example.masterlist.dto.MasterListResponseDto;
import com.example.masterlist.entity.MasterListEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring") // This is required for @Autowired
public interface MasterListMapper {

    // DTO to Entity
    @Mapping(source = "parentCode", target = "parent_code")
    @Mapping(source = "parentName", target = "parent_name")
    @Mapping(source = "faceValue", target = "face_value")
    MasterListEntity toEntity(MasterListRequestDto dto);

    // Entity to DTO
    @Mapping(source = "id", target = "id")
    @Mapping(source = "parent_code", target = "parentCode")
    @Mapping(source = "parent_name", target = "parentName")
    @Mapping(source = "face_value", target = "faceValue")
    MasterListResponseDto toResponseDto(MasterListEntity entity);

    // Update entity from DTO (for PUT or PATCH requests)
    @Mapping(source = "parentCode", target = "parent_code")
    @Mapping(source = "parentName", target = "parent_name")
    @Mapping(source = "faceValue", target = "face_value")
    void updateEntityFromDto(MasterListRequestDto dto, @MappingTarget MasterListEntity entity);
}
