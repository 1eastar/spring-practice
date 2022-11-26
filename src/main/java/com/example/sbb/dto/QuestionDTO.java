package com.example.sbb.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.sbb.entity.Answer;
import lombok.*;

@NoArgsConstructor
@Data
public class QuestionDTO {
    private String title;
    private String content;
    private List<Answer> answerList;

    @Builder
    public QuestionDTO(String title, String content, List<Answer> answerList) {
        this.title = title;
        this.content = content;
        this.answerList = answerList;
    }
}
