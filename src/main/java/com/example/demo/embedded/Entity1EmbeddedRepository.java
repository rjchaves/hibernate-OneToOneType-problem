package com.example.demo.embedded;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Entity1EmbeddedRepository extends CrudRepository<Entity1Embedded, ID1> {
}
