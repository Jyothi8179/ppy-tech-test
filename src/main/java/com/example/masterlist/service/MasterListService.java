package com.example.masterlist.service;

import com.example.masterlist.dto.MasterListRequest;
import com.example.masterlist.dto.MasterListResponse;
import com.example.masterlist.entity.MasterListEntity;
import com.example.masterlist.repository.MasterListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MasterListService {

    private final MasterListRepository masterListRepository;



    public Page<MasterListResponse> getMasterList(MasterListRequest request, Pageable pageable) {
        return masterListRepository.findAll(pageable).map(this::mapToResponse);
    }

    public void saveMasterList(MasterListRequest request) {
        MasterListEntity entity = new MasterListEntity();
        entity.setParent_code(request.getData().getStatus().get("parent_code"));
        entity.setParent_name(request.getData().getStatus().get("parent_name"));
        entity.setName(request.getData().getStatus().get("name"));
        masterListRepository.save(entity);
    }

    private MasterListResponse mapToResponse(MasterListEntity entity) {
        MasterListResponse response = new MasterListResponse();
        response.setParent_code(entity.getParent_code());
        response.setParent_name(entity.getParent_name());
        response.setName(entity.getName());
        response.setPlan(entity.getPlan().name());
        response.setOption(entity.getOption().name());
        response.setOption_frequency(entity.getOption_frequency().name());
        response.setSub_category(entity.getSub_category().name());
        response.setSector(entity.getSector().name());
        response.setBenchmark(entity.getBenchmark().name());
        response.setFace_value(entity.getFace_value());
        response.setTransaction_mode_allowed(entity.getTransaction_mode_allowed());
        return response;
    }
}
