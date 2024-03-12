package com.Chaitanya.QuizApplication.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Chaitanya.QuizApplication.Service.QuizService;





@RestController
@RequestMapping("quiz")
public class QuizController {
	@Autowired
	QuizService quizService;
	@PostMapping("create")
	public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numq, @RequestParam String title){
		return quizService.createQuiz(category, numq, title);
		
	}
	
}
