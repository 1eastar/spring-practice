package com.example.sbb.service;

import com.example.sbb.dto.QuestionDTO;
import com.example.sbb.entity.Question;

import java.util.List;

public interface QuestionService {
    Question getQuestion(Integer id);
    List<Question> getList();
    Question register(QuestionDTO dto);

    default Question dtoToEntity(QuestionDTO dto) {
        Question question = Question.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
//                .createDate(dto.getCreateDate())
//                .answerList(dto.getAnswerList())
                .build();
        return question;
    }

    default QuestionDTO entityToDto(Question question) {
        QuestionDTO dto = QuestionDTO.builder()
                .title(question.getTitle())
                .content(question.getContent())
                .answerList((question.getAnswerList()))
                .build();
        return dto;
    }
}
