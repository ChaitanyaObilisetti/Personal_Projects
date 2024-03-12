package com.Chaitanya.QuizApplication.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Chaitanya.QuizApplication.Service.QuestionService;
import com.Chaitanya.QuizApplication.model.Question;

@RestController
@RequestMapping("question")
public class QuestionController {
	@Autowired
	QuestionService questionService;

	@GetMapping("allQuestions")
	public ResponseEntity<List<Question>> getAllQuestions() {
		return questionService.getAllQuestions();
	}
	
	@GetMapping("category/{category}")
	public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
		return questionService.getQuestionsByCategory(category);
	}
	
	@PostMapping("add")
	public ResponseEntity<String> addQuestions(@RequestBody Question question ) {
		return questionService.addQuestion(question);
	}
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteQuestionById(@PathVariable Integer id) {
		return questionService.deleteQuestion(id);
	}
	@PutMapping("update/{category}/{id}")
	public ResponseEntity<Question> updateQuestionByCategory(@PathVariable String category,@PathVariable Integer id,@RequestBody Question question) {
		return questionService.updateQuestions(category,id, question);
	}
}
