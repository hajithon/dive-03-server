package com.goldbalance.dive.domain.article.repository;

import com.goldbalance.dive.domain.article.domain.Answer;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {

    Optional<Answer> findByQuizId(Long quizId);
}
