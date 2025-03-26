package com.example.masterlist.dto;

import com.example.masterlist.entity.enums.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

@Data
public class MasterListRequestDto {

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
