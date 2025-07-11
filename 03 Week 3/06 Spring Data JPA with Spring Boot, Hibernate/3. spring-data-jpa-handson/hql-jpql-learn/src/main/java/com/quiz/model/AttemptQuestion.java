package com.quiz.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "attempt_question")
public class AttemptQuestion {

    @Id
    @Column(name = "aq_id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aq_at_id", nullable = false) // FK to Attempt
    private Attempt attempt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aq_qu_id", nullable = false) // FK to Question
    private Question question;

    @OneToMany(mappedBy = "attemptQuestion", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<AttemptOption> attemptOptions;

    // --- Getters and Setters ---

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Attempt getAttempt() {
        return attempt;
    }

    public void setAttempt(Attempt attempt) {
        this.attempt = attempt;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public List<AttemptOption> getAttemptOptions() {
        return attemptOptions;
    }

    public void setAttemptOptions(List<AttemptOption> attemptOptions) {
        this.attemptOptions = attemptOptions;
    }
}
