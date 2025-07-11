package com.quiz.model;

import jakarta.persistence.*;

@Entity
@Table(name = "option")
public class Option {

    @Id
    @Column(name = "op_id")
    private int id;

    @Column(name = "op_text")
    private String text;

    @ManyToOne
    @JoinColumn(name = "op_qu_id") // FK to question
    private Question question;

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public Question getQuestion() { return question; }
    public void setQuestion(Question question) { this.question = question; }
}
