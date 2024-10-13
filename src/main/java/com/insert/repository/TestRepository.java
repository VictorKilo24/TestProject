package com.insert.repository;

import com.insert.entity.InsertEntity;
import org.springframework.data.repository.CrudRepository;


public interface TestRepository extends CrudRepository<InsertEntity, Long> {
}
