package com.example.sbb.controller;

import com.example.sbb.dto.AnswerDTO;
import com.example.sbb.entity.Answer;
import com.example.sbb.service.AnswerServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/answer")
@Controller
@Log4j2
public class AnswerController {

    private final AnswerServiceImpl answerService;

    @GetMapping
    @ResponseBody
    public ResponseEntity all() {
        List<Answer> la = this.answerService.getAnswers();
        return new ResponseEntity<List<Answer>>(la, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity listByQuestion(@PathVariable("id") Integer id) {
        List<Answer> la = this.answerService.getAnswersByQuestionId(id);
        return new ResponseEntity<List<Answer>>(la, HttpStatus.ACCEPTED);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity register(@RequestBody AnswerDTO dto) {
        log.info("=================================================================");
        log.info(dto);
        log.info("=================================================================");
        Answer answer = this.answerService.register(dto);
        return new ResponseEntity<Answer>(answer, HttpStatus.CREATED);
    }
}
