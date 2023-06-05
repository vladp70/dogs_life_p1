package com.db.grad.javaapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "owners")
public class Owners {

    @Id
    private long owner_id;
    private String name;

    public Owners() {

    }

    public Owners(long id, String name, long age) {
        this.owner_id=id;
        this.name = name;
    }

    @Id
    public long getId() {
        return owner_id;
    }
    public void setId(long id) {
        this.owner_id = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}