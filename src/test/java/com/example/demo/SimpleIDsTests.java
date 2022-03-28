package com.example.demo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.f4b6a3.uuid.UuidCreator;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleIDsTests {

    @Autowired
    Entity1Repository entity1Repository;

    @Autowired
    Entity2Repository entity2Repository;

    @Test
    public void testWithTwoSaves() {
        var entity1 = new Entity1(UuidCreator.getSequential().toString());
        var entity2 = new Entity2(UuidCreator.getSequential().toString(), entity1);

        entity1Repository.save(entity1);
        entity2Repository.save(entity2);

        entity1.setValue(1);
        entity2.setValue(2);

        entity1Repository.save(entity1);
        entity2Repository.save(entity2);

        entity1 = entity1Repository.findById(entity1.getId()).get();
        entity2 = entity2Repository.findById(entity2.getId()).get();
        assertEquals(Integer.valueOf(1), entity1.getValue());
        assertEquals(Integer.valueOf(2), entity2.getValue());
    }
}
