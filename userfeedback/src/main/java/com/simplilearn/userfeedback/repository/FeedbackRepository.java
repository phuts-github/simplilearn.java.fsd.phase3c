package com.simplilearn.userfeedback.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.userfeedback.model.Feedback;

public interface FeedbackRepository extends JpaRepository <Feedback, Integer>{

}
