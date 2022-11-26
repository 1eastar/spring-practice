package com.example.sbb.service;

import com.example.sbb.dto.AnswerDTO;
import com.example.sbb.entity.Answer;
import com.example.sbb.entity.Question;
import com.example.sbb.exception.DataNotFoundException;
import com.example.sbb.repository.AnswerRepository;
import com.example.sbb.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AnswerServiceImpl implements AnswerService{

    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    @Override
    public List<Answer> getAnswersByQuestionId(Integer id) {
        Optional<Question> q = this.questionRepository.findById(id);
        if(!q.isPresent()) {
            throw new DataNotFoundException("no matching question with id");
        }
        return this.answerRepository.findByQuestion(q.get());
    }

    @Override
    public List<Answer> getAnswers() {
        List<Answer> la = this.answerRepository.findAll();
        return la;
    }

    @Override
    public Answer register(@NotNull AnswerDTO dto) {
        Optional<Question> q = this.questionRepository.findById(dto.getQuestion_id());
        if(!q.isPresent()) {
            throw new DataNotFoundException("no matching question with id");
        }

        Answer answer = Answer.builder()
                .content(dto.getContent())
                .question(q.get())
                .build();

        return this.answerRepository.save(answer);
    }
}
