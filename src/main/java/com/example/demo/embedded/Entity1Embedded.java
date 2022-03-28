package com.example.demo.embedded;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

@Entity
public class Entity1Embedded {
    @EmbeddedId
    private ID1 id;

    @OneToOne(mappedBy = "entity1Embedded", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Entity2Embedded entity2Embedded;

    @Column
    private Integer value;

    public Entity1Embedded() {
        this.value = 0;
    }

    public Entity1Embedded(ID1 id1) {
        this();
        this.id = id1;
    }

    public Entity1Embedded(ID1 id1, Entity2Embedded entity2Embedded) {
        this(id1);
        this.entity2Embedded = entity2Embedded;
    }

    public ID1 getId() {
        return id;
    }

    public void setId(ID1 id) {
        this.id = id;
    }

    public Entity2Embedded getEntity2Embedded() {
        return entity2Embedded;
    }

    public void setEntity2Embedded(Entity2Embedded entity2Embedded) {
        this.entity2Embedded = entity2Embedded;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
