package com.cg.onlinetest.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinetest.entity.ExamUserAssign;
import com.cg.onlinetest.entity.Questions;
import com.cg.onlinetest.service.IExamAdminService;
import com.cg.onlinetest.service.IExamService;

@RestController
public class ExamAdminController {
	
	@Autowired
	private IExamAdminService service;
	
	@CrossOrigin
	@PostMapping("/addQuestion")
	public boolean addQuestion(@RequestBody Questions question) {
		service.addQuestion(question);
		return true;
	}
	
	@CrossOrigin
	@GetMapping("/assignExam/{examid}/{userid}")
	public boolean assignExamToUser( @PathVariable("examid") int examId, @PathVariable("userid") int userId) {
		
		service.assignExamToUser(examId, userId);
		return true;
	}

}
