package com.example.demo.embedded;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Entity2EmbeddedRepository extends CrudRepository<Entity2Embedded, ID2> {
}
