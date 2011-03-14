package com.fairfield.services.helpers.builders;

import java.util.ArrayList;
import java.util.List;

import org.jbpm.graph.exe.ProcessInstance;
import org.jbpm.taskmgmt.exe.TaskInstance;

import com.fairfield.common.Constants;
import com.fairfield.rules.vo.ApprovalSubmitForm;

public class ApprovalFormListBuilder {
	List<TaskInstance> taskList;
	List<ApprovalSubmitForm> formList = new ArrayList<ApprovalSubmitForm>();
	
	public void setTaskList(List<TaskInstance> taskList) {
		this.taskList = taskList;
	}
	public List<ApprovalSubmitForm> createList(){
		for(TaskInstance taskInstance:taskList){
			ProcessInstance pi = taskInstance.getProcessInstance();
			String status = pi.getRootToken().getNode().getName();
			if(status.equals(Constants.PENDING_FOR_HOD)){
				ApprovalSubmitForm submittedForm = new ApprovalSubmitForm();
				submittedForm.setUserId((String)taskInstance.getVariable("userId"));
				submittedForm.setUserName((String)taskInstance.getVariable("userName"));
				submittedForm.setProcessId(pi.getId());
				formList.add(submittedForm);
			}
		}
		return formList;
	}
}
