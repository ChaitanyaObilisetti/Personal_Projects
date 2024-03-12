package com.Chaitanya.QuizApplication.DAO;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import com.Chaitanya.QuizApplication.model.Question;

import jakarta.persistence.EntityManager;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {

    public static final EntityManager entityManager = null;
		List<Question> findByCategory(String category);
		
		@Query(value="SELECT * FROM question q where q.category=:category ORDER BY RANDOM() LIMIT :numq", nativeQuery=true)
		List<Question> findRandomQuestionsByCategory(String category, int numq);
		
		Question findByCategoryAndId(String category,Integer id);
		
		
}
