package com.cg.onlinetest.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinetest.entity.Exam;
import com.cg.onlinetest.entity.User;
import com.cg.onlinetest.exceptions.ExamException;
import com.cg.onlinetest.exceptions.NotAvailableException;
import com.cg.onlinetest.exceptions.UserIdException;
import com.cg.onlinetest.service.IExamService;
import com.cg.onlinetest.util.OnlineConstants;

@RestController
public class ExamController {

	@Autowired
	private IExamService service;

	@PostMapping("/addUser")
	public boolean addUser(@RequestBody User user) throws UserIdException, ExamException {
		try {
			return service.addUser(user);
		} catch (DataIntegrityViolationException ex) {
			throw new ExamException(OnlineConstants.ID_EXISTS);
		}
	}

	@PostMapping("/addExam")
	public boolean addExam(@RequestBody Exam exam) throws ExamException {
		try {
			return service.addExam(exam);
		} catch (DataIntegrityViolationException ex) {
			throw new ExamException(OnlineConstants.ID_EXISTS);
		}
	}

	@GetMapping("/viewuserbyid/{userid}")
	public User viewUserByID(@PathVariable("userid") int userId) throws NotAvailableException {
		return service.viewUserByID(userId);
	}

}
