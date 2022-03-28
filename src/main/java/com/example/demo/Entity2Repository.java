package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Entity2Repository extends CrudRepository<Entity2, String> {
}
