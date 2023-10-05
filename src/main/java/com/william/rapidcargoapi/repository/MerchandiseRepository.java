package com.william.rapidcargoapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.william.rapidcargoapi.model.Merchandise;

@Repository
public interface MerchandiseRepository extends CrudRepository<Merchandise, Long> {

}