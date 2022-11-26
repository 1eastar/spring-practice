package com.example.sbb;

import java.util.List;
import java.util.Optional;

import com.example.sbb.entity.Answer;
import com.example.sbb.repository.AnswerRepository;
import com.example.sbb.entity.Question;
import com.example.sbb.repository.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SbbApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private AnswerRepository answerRepository;

	@Transactional
	@Test
	void dbtest() {
		Optional<Question> oq = this.questionRepository.findById(2);
		assertTrue(oq.isPresent());
		Question q = oq.get();

		List<Answer> as = q.getAnswerList();
		assertEquals(1, as.size());
	}
}
