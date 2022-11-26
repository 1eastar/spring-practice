package com.example.sbb.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id")
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String title;
    @Column(columnDefinition = "TEXT")
    private String content;

    @CreatedDate
    private LocalDateTime createDate;

//    @JsonIgnoreProperties("question")   // 무한 루프 JSON을 없애기 위해 answerList 내의 Answer 데이터들은 question 속성을 무시한다.
    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE) //"question"은 Answer 엔티티에서 Question 엔티티를 참조한 변수 명
    private List<Answer> answerList;

    @Builder
    public Question(String title, String content) {
        this.title = title;
        this.content = content;
        this.createDate = LocalDateTime.now();
        this.answerList = new ArrayList<>();
    }
}
