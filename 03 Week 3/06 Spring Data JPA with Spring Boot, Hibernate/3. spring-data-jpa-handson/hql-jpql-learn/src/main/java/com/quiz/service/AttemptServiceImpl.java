package com.quiz.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.quiz.model.Attempt;
import com.quiz.repository.AttemptRepository;

@Service
@Transactional
public class AttemptServiceImpl implements AttemptService {

    @Autowired
    private AttemptRepository attemptRepository;

    @Override
    public Attempt getAttempt(int userId, int quizId) {
        return attemptRepository.findByQuiz_IdAndUser_Id(quizId, userId)
                                .orElse(null); // returns null if not found
    }
}
