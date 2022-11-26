package com.example.sbb.repository;

import java.util.List;
import java.util.Optional;

import com.example.sbb.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    Optional<Question> findByTitle(String title);
    Question findByTitleAndContent(String title, String content);
    List<Question> findByTitleLike(String title);
}
