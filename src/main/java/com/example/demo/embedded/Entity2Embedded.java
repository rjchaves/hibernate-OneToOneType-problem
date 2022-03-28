package com.example.demo.embedded;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Entity2Embedded {

    @EmbeddedId
    private ID2 id;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "entity1embedded_id", referencedColumnName = "id", nullable = false)
    private Entity1Embedded entity1Embedded;

    @Column
    private Integer value;

    public Entity2Embedded() {
        this.value = 0;
    }

    public Entity2Embedded(ID2 id) {
        this();
        this.id = id;
    }

    public Entity2Embedded(ID2 id2, Entity1Embedded entity1Embedded) {
        this(id2);
        this.entity1Embedded = entity1Embedded;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public ID2 getId() {
        return id;
    }
}
