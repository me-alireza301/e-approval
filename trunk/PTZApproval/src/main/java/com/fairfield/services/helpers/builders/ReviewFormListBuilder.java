package com.fairfield.services.helpers.builders;

import java.util.ArrayList;
import java.util.List;

import org.jbpm.taskmgmt.exe.TaskInstance;

import com.fairfield.common.Constants;
import com.fairfield.rules.vo.ApprovalReviewForm;

public class ReviewFormListBuilder {
	List<TaskInstance> taskList;
	List<ApprovalReviewForm> formList = new ArrayList<ApprovalReviewForm>();
	public void setTaskList(List<TaskInstance> taskList) {
		this.taskList = taskList;
	}
	public List<ApprovalReviewForm> createList(){
		for(TaskInstance taskInstance:taskList){
			if(taskInstance.getName().equals(Constants.REVIEW_BY_ACCOUNTANT)){
				ApprovalReviewForm reviewForm = new ApprovalReviewForm();
				reviewForm.setUserId((String)taskInstance.getVariable("userId"));
				reviewForm.setUserName((String)taskInstance.getVariable("userName"));
				reviewForm.setProcessId((Long)taskInstance.getVariable("processId"));
				formList.add(reviewForm);
			}
		}
		return formList;
	}
	
}
