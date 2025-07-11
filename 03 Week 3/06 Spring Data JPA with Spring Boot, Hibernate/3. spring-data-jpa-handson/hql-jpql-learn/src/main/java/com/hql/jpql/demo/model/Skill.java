package com.hql.jpql.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "skill")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sk_id") // ✅ Matches column in DB
    private int id;

    @Column(name = "sk_name") // ✅ Use the actual column name in your DB
    private String name;

    @ManyToMany(mappedBy = "skillList", fetch = FetchType.LAZY)
    private List<Employee> employees;

    // --- Getters and Setters ---

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
