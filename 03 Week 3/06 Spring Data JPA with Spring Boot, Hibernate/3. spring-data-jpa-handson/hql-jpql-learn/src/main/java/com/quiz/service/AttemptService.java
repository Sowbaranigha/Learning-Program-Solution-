package com.quiz.service;

import com.quiz.model.Attempt;

public interface AttemptService {
    Attempt getAttempt(int userId, int attemptId);
}
