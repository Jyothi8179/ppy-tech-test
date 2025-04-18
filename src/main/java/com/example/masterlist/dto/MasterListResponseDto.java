package com.example.masterlist.dto;

import com.example.masterlist.entity.enums.*;
import lombok.Data;

import java.util.Map;

@Data
public class MasterListResponseDto {

    private Long id;
    private String parentCode;
    private String parentName;
    private String name;
    private PlanEnum plan;
    private OptionEnum option;
    private OptionFrequencyEnum optionFrequency;
    private SubCategoryEnum subCategory;
    private SectorEnum sector;
    private BenchmarkEnum benchmark;
    private Integer faceValue;
    private Map<String, String> transactionModeAllowed;
}
