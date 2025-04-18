package com.example.masterlist.specification;

import com.example.masterlist.entity.MasterListEntity;
import com.example.masterlist.entity.enums.*;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MasterListSpecification {

    public static Specification<MasterListEntity> getFilteredResults(Map<String, Object> filters) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filters != null && !filters.isEmpty()) {

                // String fields
                if (filters.containsKey("name") && filters.get("name") != null) {
                    predicates.add(criteriaBuilder.like(
                            criteriaBuilder.lower(root.get("name")),
                            "%" + filters.get("name").toString().toLowerCase() + "%"
                    ));
                }

                if (filters.containsKey("parent_code") && filters.get("parent_code") != null) {
                    predicates.add(criteriaBuilder.equal(
                            criteriaBuilder.lower(root.get("parent_code")),
                            filters.get("parent_code").toString().toLowerCase()
                    ));
                }

                if (filters.containsKey("parent_name") && filters.get("parent_name") != null) {
                    predicates.add(criteriaBuilder.equal(
                            criteriaBuilder.lower(root.get("parent_name")),
                            filters.get("parent_name").toString().toLowerCase()
                    ));
                }

                // Enums
                if (filters.containsKey("plan") && filters.get("plan") != null) {
                    predicates.add(criteriaBuilder.equal(
                            root.get("plan"),
                            Enum.valueOf(PlanEnum.class, filters.get("plan").toString())
                    ));
                }

                if (filters.containsKey("option") && filters.get("option") != null) {
                    predicates.add(criteriaBuilder.equal(
                            root.get("option"),
                            Enum.valueOf(OptionEnum.class, filters.get("option").toString())
                    ));
                }

                if (filters.containsKey("option_frequency") && filters.get("option_frequency") != null) {
                    predicates.add(criteriaBuilder.equal(
                            root.get("option_frequency"),
                            Enum.valueOf(OptionFrequencyEnum.class, filters.get("option_frequency").toString())
                    ));
                }

                if (filters.containsKey("sub_category") && filters.get("sub_category") != null) {
                    predicates.add(criteriaBuilder.equal(
                            root.get("sub_category"),
                            Enum.valueOf(SubCategoryEnum.class, filters.get("sub_category").toString())
                    ));
                }

                if (filters.containsKey("sector") && filters.get("sector") != null) {
                    predicates.add(criteriaBuilder.equal(
                            root.get("sector"),
                            Enum.valueOf(SectorEnum.class, filters.get("sector").toString())
                    ));
                }

                if (filters.containsKey("benchmark") && filters.get("benchmark") != null) {
                    predicates.add(criteriaBuilder.equal(
                            root.get("benchmark"),
                            Enum.valueOf(BenchmarkEnum.class, filters.get("benchmark").toString())
                    ));
                }

                // Integer field
                if (filters.containsKey("face_value") && filters.get("face_value") != null) {
                    predicates.add(criteriaBuilder.equal(
                            root.get("face_value"),
                            Integer.valueOf(filters.get("face_value").toString())
                    ));
                }

                // Map field: transaction_mode_allowed
                if (filters.containsKey("transaction_mode_key") && filters.get("transaction_mode_key") != null) {
                    String key = filters.get("transaction_mode_key").toString();
                    predicates.add(criteriaBuilder.isNotNull(root.join("transaction_mode_allowed", JoinType.LEFT).get(key)));
                }
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
