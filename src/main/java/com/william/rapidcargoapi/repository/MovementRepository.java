package com.william.rapidcargoapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.william.rapidcargoapi.model.Movement;

@Repository
public interface MovementRepository extends CrudRepository<Movement, Long> {

}