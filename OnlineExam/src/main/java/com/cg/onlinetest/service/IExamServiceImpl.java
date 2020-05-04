package com.cg.onlinetest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.onlinetest.dao.IExamDao;
import com.cg.onlinetest.entity.Exam;
import com.cg.onlinetest.entity.User;
import com.cg.onlinetest.exceptions.ExamException;
import com.cg.onlinetest.exceptions.NotAvailableException;
import com.cg.onlinetest.exceptions.UserIdException;
import com.cg.onlinetest.util.OnlineConstants;

@Service
public class IExamServiceImpl implements IExamService {

	@Autowired
	private IExamDao dao;

	@Override
	public boolean addUser(User user) throws UserIdException {

		dao.addUser(user);
		return true;

	}

	@Override
	public boolean addExam(Exam exam) throws ExamException {

		dao.addExam(exam);
		return true;

	}

	@Override
	public User viewUserByID(int userId) throws NotAvailableException {
		User user = dao.viewUserByID(userId);
		if (user == null)
			throw new NotAvailableException(OnlineConstants.USER_NOT_FOUND);
		return user;
	}

	@Override
	public List<Exam> viewExams() {
		List<Exam> examList = dao.viewExams();
		examList.sort((e1, e2)->e1.getExamName().compareTo(e2.getExamName()));
		return examList;
	}

	@Override
	public List<User> viewUsers() {
		List<User> userList = dao.viewUsers();
		userList.sort((e1, e2)->e1.getUserName().compareTo(e2.getUserName()));
		return userList;
	}
}
