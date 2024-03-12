package com.Chaitanya.QuizApplication.model;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Quiz {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
	    @Column(nullable = false)
		private String title;
		
		@ManyToMany
		private List<Question> questions;
		
		public void setId(Integer id) {
			this.id=id;
		}
		public Integer getId() {
			return id;
		}
		public void setTitle(String title) {
			this.title=title;
		}
		public String getTitle() {
			return title;
		}
		public void setQuestions(List<Question> questions) {
			this.questions=questions;
		}
		public List<Question> getQuestions(){
			return questions;
		}
	}
