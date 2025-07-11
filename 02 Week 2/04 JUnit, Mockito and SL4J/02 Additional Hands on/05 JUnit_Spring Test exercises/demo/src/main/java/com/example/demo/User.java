package com.example.demo;

import jakarta.persistence.*;

@Entity
@Table(name = "users")                 // ► avoids H2 keyword “user”
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    /* ---------- constructors ---------- */
    public User() { }                  // JPA needs the no‑args constructor

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    /* ---------- getters / setters ---------- */
    public Long getId()           { return id; }
    public void setId(Long id)    { this.id = id; }

    public String getName()       { return name; }
    public void setName(String name) { this.name = name; }
}
