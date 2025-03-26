package com.example.masterlist.entity;

import com.example.masterlist.entity.enums.*;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Map;

@Entity
@Table(name = "master_list")
@Data
public class MasterListEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String parent_code;
    private String parent_name;
    private String name;

    @Enumerated(EnumType.STRING)
    private PlanEnum plan;

    @Enumerated(EnumType.STRING)
    private OptionEnum option;

    @Enumerated(EnumType.STRING)
    private OptionFrequencyEnum option_frequency;

    @Enumerated(EnumType.STRING)
    private SubCategoryEnum sub_category;

    @Enumerated(EnumType.STRING)
    private SectorEnum sector;

    @Enumerated(EnumType.STRING)
    private BenchmarkEnum benchmark;

    private Integer face_value;

    @ElementCollection
    @CollectionTable(name = "transaction_mode_allowed", joinColumns = @JoinColumn(name = "master_id"))
    @MapKeyColumn(name = "mode")
    @Column(name = "allowed")
    private Map<String, String> transaction_mode_allowed;
}
