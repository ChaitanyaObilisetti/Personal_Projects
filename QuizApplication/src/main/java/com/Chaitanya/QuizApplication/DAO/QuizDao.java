package com.Chaitanya.QuizApplication.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Chaitanya.QuizApplication.model.Quiz;

public interface QuizDao extends JpaRepository<Quiz, Integer> {
	
	

}
