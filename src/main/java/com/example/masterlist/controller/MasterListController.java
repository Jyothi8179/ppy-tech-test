package com.example.masterlist.controller;

import com.example.masterlist.dto.MasterListFilterRequestDto;
import com.example.masterlist.dto.MasterListRequestDto;
import com.example.masterlist.dto.MasterListResponseDto;
import com.example.masterlist.entity.MasterListEntity;
import com.example.masterlist.mapper.MasterListMapper;
import com.example.masterlist.service.MasterListService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/master-list")
public class MasterListController {

    @Autowired MasterListService masterListService;
    @Autowired MasterListMapper masterListMapper;

    public MasterListController(MasterListService masterListService) {
        this.masterListService = masterListService;
    }

    @PostMapping
    public Object getMasterList(@Valid @RequestBody MasterListFilterRequestDto request) {
        Pageable pageable = PageRequest.of(request.getStart() / request.getLength(), request.getLength());

        if (request.getCount_only() != null && request.getCount_only()) {
            Long count = masterListService.countMasterList(request);
            return count;
        } else {
            Page<MasterListEntity> pageResult = masterListService.getFilteredMasterList(request, pageable);
             return masterListService.filterResponseByFeilds(request.getFields(),pageResult.getContent());
        }
    }

    @PostMapping("/save")
    public MasterListResponseDto saveMasterList(@Valid @RequestBody MasterListRequestDto request) {
        MasterListEntity masterList = masterListService.saveMasterList(request);
        return masterListMapper.toResponseDto(masterList);
    }
    @GetMapping("/test")
    public String testing(){
        return "Working fine";
    }
}
