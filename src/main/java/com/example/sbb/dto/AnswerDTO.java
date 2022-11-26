package com.example.sbb.dto;

import com.example.sbb.entity.Question;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class AnswerDTO {
    private String content;
    private Integer question_id;

    @Builder
    public AnswerDTO(String content, Integer question_id) {
        this.content = content;
        this.question_id = question_id;
    }
}
