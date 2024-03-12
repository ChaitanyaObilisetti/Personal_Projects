package com.Chaitanya.QuizApplication.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Chaitanya.QuizApplication.DAO.QuestionDao;
import com.Chaitanya.QuizApplication.DAO.QuizDao;
import com.Chaitanya.QuizApplication.model.Question;
import com.Chaitanya.QuizApplication.model.Quiz;

@Service
public class QuizService {
	@Autowired
	QuizDao quizDao;
	@Autowired
	QuestionDao questionDao;

	public ResponseEntity<String> createQuiz(String category, int numq, String title) {
		List<Question> questions= questionDao.findRandomQuestionsByCategory(category, numq);
		Quiz quiz=new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		quizDao.save(quiz);
		return new ResponseEntity<>("Success",HttpStatus.CREATED);
	
	}
}
