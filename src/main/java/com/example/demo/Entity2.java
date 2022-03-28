package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Entity2 {

    @Id
    private String id;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "entity1_id", referencedColumnName = "id", nullable = false)
    private Entity1 entity1;

    @Column
    private Integer value;

    public Entity2() {
    }

    public Entity2(String id, Entity1 entity1) {
        this.id = id;
        this.entity1 = entity1;
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

    public Entity1 getEntity1() {
        return entity1;
    }

    public void setEntity1(Entity1 entity1) {
        this.entity1 = entity1;
    }
}
