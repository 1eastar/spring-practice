package com.example.sbb.controller;

import java.time.LocalDateTime;
import java.util.List;

import com.example.sbb.dto.QuestionDTO;
import com.example.sbb.entity.Question;
import com.example.sbb.service.QuestionServiceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@RequestMapping("/question")
@Controller
public class QuestionController {

    private final QuestionServiceImpl questionService;

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity getQuestion(@PathVariable("id") Integer id) {
        Question q = this.questionService.getQuestion((id));
        return new ResponseEntity<Question>(q, HttpStatus.ACCEPTED);
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity list() {
        List<Question> questionList = this.questionService.getList();
        return new ResponseEntity<List<Question>>(questionList, HttpStatus.ACCEPTED);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity register(@RequestBody QuestionDTO dto) {
        Question question = this.questionService.register(dto);

        return new ResponseEntity<Question>(question, HttpStatus.CREATED);
    }
}
