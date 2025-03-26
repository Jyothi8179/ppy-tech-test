package com.example.masterlist.service;

import com.example.masterlist.dto.MasterListFilterRequestDto;
import com.example.masterlist.dto.MasterListRequestDto;
import com.example.masterlist.entity.MasterListEntity;
import com.example.masterlist.mapper.MasterListMapper;
import com.example.masterlist.repository.MasterListRepository;
import com.example.masterlist.specification.MasterListSpecification;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class MasterListService {

    Logger logger = LoggerFactory.getLogger(MasterListService.class);
    @Autowired private MasterListRepository masterListRepository;
    @Autowired private MasterListMapper masterListMapper;

    public Page<MasterListEntity> getFilteredMasterList(MasterListFilterRequestDto request, Pageable pageable) {
        Map<String, Object> filterParam = request.getFilterParam();
        Specification<MasterListEntity> spec = MasterListSpecification.getFilteredResults(filterParam);
        logger.info("Filter Params: {}", filterParam);


        return masterListRepository.findAll(spec, pageable);
    }

    public Long countMasterList(MasterListFilterRequestDto request) {
        Map<String, Object> filterParam = request.getFilterParam();
        Specification<MasterListEntity> spec = MasterListSpecification.getFilteredResults(filterParam);
        logger.info("Filter Params: {}", filterParam);
        return masterListRepository.count(spec);
    }

    public MasterListEntity saveMasterList(MasterListRequestDto request) {
        MasterListEntity entity = masterListMapper.toEntity(request);
        return masterListRepository.save(entity);
    }
}
