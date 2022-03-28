package com.example.demo.embedded;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.github.f4b6a3.uuid.UuidCreator;

@Embeddable
public class ID2 implements Serializable {

    @Column
    private String id;

    public ID2(String id) {
        this.id = id;
    }

    public ID2() {
        this(UuidCreator.getSequential().toString());
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ID2 id1 = (ID2) o;
        return Objects.equals(id, id1.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
