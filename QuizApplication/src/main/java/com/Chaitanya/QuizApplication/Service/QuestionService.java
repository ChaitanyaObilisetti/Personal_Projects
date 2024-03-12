package com.Chaitanya.QuizApplication.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Chaitanya.QuizApplication.DAO.QuestionDao;
import com.Chaitanya.QuizApplication.model.Question;

@Service
public class QuestionService {
	@Autowired
	QuestionDao questionDao;
	
	public ResponseEntity<List<Question>> getAllQuestions() {
		try {
			return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
		try{
			return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);

	}

	public ResponseEntity<String> addQuestion(Question question) {
		try{
			questionDao.save(question);
			return new ResponseEntity<>("Success", HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ResponseEntity<>("Bad Request" ,HttpStatus.BAD_REQUEST);
		}
	public ResponseEntity<String> deleteQuestion(Integer id) {
		try{
			questionDao.deleteById(id);
			return new ResponseEntity<>("Success",HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ResponseEntity<>("Bad Request",HttpStatus.BAD_REQUEST);

	}	
	public ResponseEntity<Question> updateQuestions(String category,Integer id,Question question){
		Question existingquestion= questionDao.findByCategoryAndId(category,id);
		try {
			existingquestion.setQuestionTitle(question.getQuestionTitle());
			existingquestion.setOption1(question.getOption1());
			existingquestion.setOption2(question.getOption2());
			existingquestion.setOption3(question.getOption3());
			existingquestion.setOption4(question.getOption4());
			existingquestion.setRightAnswer(question.getRightAnswer());
			existingquestion.setDifficultyLevel(question.getDifficultyLevel());
			questionDao.save(existingquestion);
			return new ResponseEntity<>(existingquestion,HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
