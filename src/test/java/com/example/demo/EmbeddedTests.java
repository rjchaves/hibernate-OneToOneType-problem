package com.example.demo;


import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.embedded.Entity1Embedded;
import com.example.demo.embedded.Entity1EmbeddedRepository;
import com.example.demo.embedded.Entity2Embedded;
import com.example.demo.embedded.Entity2EmbeddedRepository;
import com.example.demo.embedded.ID1;
import com.example.demo.embedded.ID2;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmbeddedTests {
    @Autowired
    Entity1EmbeddedRepository entity1EmbeddedRepository;

    @Autowired
    Entity2EmbeddedRepository entity2EmbeddedRepository;

    @Test
    public void testWith2Saves() {
        var entity1Embedded = new Entity1Embedded(new ID1());
        var entity2Embedded = new Entity2Embedded(new ID2(), entity1Embedded);

        entity1EmbeddedRepository.save(entity1Embedded);
        entity2EmbeddedRepository.save(entity2Embedded);

        entity1Embedded.setValue(1);
        entity2Embedded.setValue(2);

        entity1EmbeddedRepository.save(entity1Embedded);
        entity2EmbeddedRepository.save(entity2Embedded);

        entity1Embedded = entity1EmbeddedRepository.findById(entity1Embedded.getId()).get();
        entity2Embedded = entity2EmbeddedRepository.findById(entity2Embedded.getId()).get();
        assertEquals(Integer.valueOf(1), entity1Embedded.getValue());
        assertEquals(Integer.valueOf(2), entity2Embedded.getValue());

    }
}
