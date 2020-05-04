package com.cg.onlinetest.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.onlinetest.dao.IExamDao;
import com.cg.onlinetest.entity.ExamUserAssign;
import com.cg.onlinetest.entity.Questions;
import com.cg.onlinetest.util.OnlineConstants;

@Service
@Transactional
public class ExamAdminServiceImpl implements IExamAdminService {
	
	@Autowired
	IExamDao dao;

	public boolean addQuestion(Questions question) {
		int qid = dao.getMaxQuestionId() + 1;
		question.setQuestionId(qid);
		return dao.addQuestion(question);
	}

	public boolean assignExamToUser(int examId, int userId) {
	   int id = dao.getMaxExamUserAssignId()+1;
	   ExamUserAssign assign = new ExamUserAssign();
	   assign.setExamUserAssignId(id);
	   assign.setDateOfExam(LocalDate.now());
	   assign.setStatus(OnlineConstants.READY_TO_START);
	   assign.getExam().setExamId(examId);
	   assign.getUser().setUserId(userId);
		return dao.assignExamToUser(assign);
		
	}

	
}
