package com.quiz.repository;

import com.quiz.model.Attempt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AttemptRepository extends JpaRepository<Attempt, Integer> {
    Optional<Attempt> findByQuiz_IdAndUser_Id(int quizId, int userId);
}
