package com.example.masterlist.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MasterListResponse {
    private String parent_code;
    private String parent_name;
    private String name;
    private String plan;
    private String option;
    private String option_frequency;
    private String sub_category;
    private String sector;
    private String benchmark;
    private Integer face_value;
    private Map<String, String> transaction_mode_allowed;
}
