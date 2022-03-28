package com.example.demo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Entity1 {

    @Id
    private String id;

    @OneToOne(mappedBy = "entity1", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Entity2 entity2;

    @Column
    private Integer value;

    public Entity1() {
    }

    public Entity1(String id) {
        this.id = id;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Entity2 getEntity2() {
        return entity2;
    }

    public void setEntity2(Entity2 entity2) {
        this.entity2 = entity2;
    }
}
