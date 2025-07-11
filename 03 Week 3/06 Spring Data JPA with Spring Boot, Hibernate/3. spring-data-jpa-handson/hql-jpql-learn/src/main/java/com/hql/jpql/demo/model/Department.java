package com.hql.jpql.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @Column(name = "dp_id")
    private int id;

    @Column(name = "dp_name")
    private String name;

    // === Getter and Setter ===

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {           // <-- ADD THIS METHOD
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
