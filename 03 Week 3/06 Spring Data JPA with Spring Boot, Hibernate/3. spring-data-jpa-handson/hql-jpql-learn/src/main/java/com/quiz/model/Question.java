package com.quiz.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @Column(name = "qu_id")
    private int id;

    @Column(name = "qu_text")
    private String text;

    @Column(name = "qu_answer")
    private int correctOptionId; // This is a foreign key reference to Option.op_id

    @Column(name = "qu_score")
    private double score;

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Option> options;

    // --- Getters and Setters ---

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getCorrectOptionId() {
        return correctOptionId;
    }

    public void setCorrectOptionId(int correctOptionId) {
        this.correctOptionId = correctOptionId;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }
}
