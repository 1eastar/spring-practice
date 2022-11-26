package com.example.sbb.service;

import com.example.sbb.dto.AnswerDTO;
import com.example.sbb.entity.Answer;
import com.example.sbb.entity.Question;
import com.example.sbb.repository.QuestionRepository;

import java.util.List;

public interface AnswerService {
    List<Answer> getAnswersByQuestionId(Integer id);
    List<Answer> getAnswers();
    Answer register(AnswerDTO dto);

}
