package com.quiz.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    private int id;

    private String name;

    @OneToMany(mappedBy = "user")  // Mapped by the "user" field in Attempt
    private List<Attempt> attempts;

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<Attempt> getAttempts() { return attempts; }
    public void setAttempts(List<Attempt> attempts) { this.attempts = attempts; }
}
