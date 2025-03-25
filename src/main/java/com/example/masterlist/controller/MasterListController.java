package com.example.masterlist.controller;

import com.example.masterlist.dto.MasterListRequest;
import com.example.masterlist.dto.MasterListResponse;
import com.example.masterlist.service.MasterListService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/master_list")
public class MasterListController {

    private final MasterListService masterListService;

    public MasterListController(MasterListService masterListService) {
        this.masterListService = masterListService;
    }

    @PostMapping
    public Page<MasterListResponse> getMasterList(@RequestBody MasterListRequest request, Pageable pageable) {
        return masterListService.getMasterList(request, pageable);
    }

    @PostMapping("/save")
    public String saveMasterList(@RequestBody MasterListRequest request) {
        masterListService.saveMasterList(request);
        return "Data Saved Successfully!";
    }
}
