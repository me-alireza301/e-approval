package com.fairfield.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.jbpm.JbpmConfiguration;
import org.jbpm.JbpmContext;
import org.jbpm.graph.exe.ProcessInstance;
import org.jbpm.taskmgmt.exe.TaskInstance;
import org.springframework.stereotype.Service;

import com.fairfield.common.Constants;
import com.fairfield.rules.vo.ApprovalReviewForm;
import com.fairfield.rules.vo.ApprovalSubmitForm;
import com.fairfield.services.helpers.builders.ApprovalFormListBuilder;
import com.fairfield.services.helpers.builders.ReviewFormListBuilder;
import com.fairfield.services.helpers.commands.ApproveSubmitFormCommand;
import com.fairfield.services.helpers.commands.FormCommandHolder;
import com.fairfield.services.helpers.commands.SubmitApprovalFormCommand;

@Service("approvalFormService")
public class ApprovalFormServiceImpl implements ApprovalFormService {

	@Override
	public String submitApprovalForm(String userId, String name) {
		String status = "";
		JbpmConfiguration conf = JbpmConfiguration.parseResource("jbpm.cfg.xml");
		JbpmContext context = conf.createJbpmContext();
		try {
			ProcessInstance pi = runStartNode(context);
			FormCommandHolder.execute(new SubmitApprovalFormCommand(userId, name, pi));
			status = pi.getRootToken().getNode().getName();
		} catch (Exception e) {
			e.printStackTrace();
		}
		context.close();
		return status;
	}
	private ProcessInstance runStartNode(JbpmContext context) {
		ProcessInstance pi = context.newProcessInstance("requestFacilityDefinition");
		pi.signal();
		return pi;
	}
	public List<ApprovalSubmitForm> getApprovalSubmitFormListForHOD(){
		JbpmConfiguration conf = JbpmConfiguration.parseResource("jbpm.cfg.xml");
		JbpmContext context = conf.createJbpmContext();
		ApprovalFormListBuilder builder = new ApprovalFormListBuilder();
		builder.setTaskList(context.getTaskList("hod"));
		List<ApprovalSubmitForm> formList = builder.createList();
		context.close();
		return formList;
	}
	
	public ApprovalReviewForm getApprovalReviewForm(long processId){
		JbpmConfiguration conf = JbpmConfiguration.parseResource("jbpm.cfg.xml");
		JbpmContext context = conf.createJbpmContext();
		ProcessInstance pi = context.getProcessInstance(processId);
		ApprovalReviewForm reviewForm = new ApprovalReviewForm();
		reviewForm.setUserId((String)pi.getContextInstance().getVariable("userId"));
		reviewForm.setUserName((String)pi.getContextInstance().getVariable("userName"));
		reviewForm.setRemark((String)pi.getContextInstance().getVariable("remark"));
		reviewForm.setProcessId(processId);
		context.close();
		return reviewForm;
	}
	
	public void approveSubmittedForm(String remark,long processId) {
		JbpmConfiguration conf = JbpmConfiguration.parseResource("jbpm.cfg.xml");
		JbpmContext context = conf.createJbpmContext();
		ProcessInstance pi = context.getProcessInstance(processId);
		FormCommandHolder.execute(new ApproveSubmitFormCommand(remark, pi));
		context.close();
	}
	
	public List<ApprovalReviewForm> getReviewFormListForAccountant(){
		JbpmConfiguration conf = JbpmConfiguration.parseResource("jbpm.cfg.xml");
		JbpmContext context = conf.createJbpmContext();
		ReviewFormListBuilder builder = new ReviewFormListBuilder();
		builder.setTaskList(context.getTaskList("accountant"));
		List<ApprovalReviewForm> formList = builder.createList();
		context.close();
		return formList;
	}
}