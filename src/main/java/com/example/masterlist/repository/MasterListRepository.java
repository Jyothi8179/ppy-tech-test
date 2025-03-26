package com.example.masterlist.repository;

import com.example.masterlist.entity.MasterListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterListRepository extends JpaRepository<MasterListEntity, Long>,
        JpaSpecificationExecutor<MasterListEntity> {
}