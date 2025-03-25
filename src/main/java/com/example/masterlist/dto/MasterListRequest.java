package com.example.masterlist.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MasterListRequest {
    private DataRequest data;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DataRequest {
        private Map<String, String> status;
        private Object fields;
        private Boolean count_only;
        private SearchRequest search;
        private Integer start;
        private Integer length;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SearchRequest {
        private String value;
    }
}
