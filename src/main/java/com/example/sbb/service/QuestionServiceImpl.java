package com.example.sbb.service;

import java.util.List;
import java.util.Optional;

import com.example.sbb.dto.QuestionDTO;
import com.example.sbb.entity.Question;
import com.example.sbb.exception.DataNotFoundException;
import com.example.sbb.repository.QuestionRepository;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequiredArgsConstructor
@Service
@Log4j2
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    @Override
    public Question getQuestion(Integer id) {
        Optional<Question> oq = this.questionRepository.findById(id);
        if(oq.isPresent()) {
            return oq.get();
        } else {
            throw new DataNotFoundException("question not found");
        }
    }

    @Override
    public List<Question> getList() {
        return this.questionRepository.findAll();
    }

    @Override
    public Question register(QuestionDTO dto) {
        log.info("----------dto---------");
        log.info(dto);

        Question question = dtoToEntity(dto);

        log.info("----------entity------");
        log.info(question);

        Question q = this.questionRepository.save(question);

        return q;
    }
}
