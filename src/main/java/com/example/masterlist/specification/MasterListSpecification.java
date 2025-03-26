package com.example.masterlist.specification;

import com.example.masterlist.entity.MasterListEntity;
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

                if (filters.containsKey("name") && filters.get("name") != null) {
                    predicates.add(criteriaBuilder.like(
                            criteriaBuilder.lower(root.get("name")),
                            "%" + String.valueOf(filters.get("name")).toLowerCase() + "%"
                    ));
                }


                if (filters.containsKey("plan") && filters.get("plan") != null) {
                    predicates.add(criteriaBuilder.equal(
                            criteriaBuilder.lower(root.get("plan")),
                            String.valueOf(filters.get("plan")).toLowerCase()
                    ));
                }

                if (filters.containsKey("option") && filters.get("option") != null) {
                    predicates.add(criteriaBuilder.equal(
                            criteriaBuilder.lower(root.get("option")),
                            String.valueOf(filters.get("option")).toLowerCase()
                    ));
                }

                if (filters.containsKey("sub_category") && filters.get("sub_category") != null) {
                    predicates.add(criteriaBuilder.equal(
                            criteriaBuilder.lower(root.get("sub_category")),
                            String.valueOf(filters.get("sub_category")).toLowerCase()
                    ));
                }
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
