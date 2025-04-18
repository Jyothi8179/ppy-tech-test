package com.example.masterlist.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MasterListFilterRequestDto {

    @NotNull(message = "fields is mandatory")
    private List<String> fields;

    @NotNull(message = "count_only is mandatory")
    private Boolean count_only;
    private Object search;

    @NotNull(message = "start is mandatory")
    private Integer start;

    @NotNull(message = "length is mandatory")
    private Integer length;

    private Map<String, Object> filterParam;
}

@Data
class SearchDto {
    private String value; // Schema name for search
}
