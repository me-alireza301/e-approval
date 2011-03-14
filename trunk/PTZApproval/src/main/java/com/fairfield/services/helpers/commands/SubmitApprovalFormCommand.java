package com.fairfield.services.helpers.commands;

import java.util.ArrayList;
import java.util.List;

import org.jbpm.graph.exe.ProcessInstance;
import org.jbpm.taskmgmt.exe.TaskInstance;

import com.fairfield.common.Constants;

public class SubmitApprovalFormCommand implements IFormCommand{
	private String userId;
	private String name;
	private ProcessInstance pi;
	public SubmitApprovalFormCommand(String userId,String name,ProcessInstance pi){
		this.userId = userId;
		this.name = name;
		this.pi = pi;
	}
	@Override
	public void execute() {
		List<TaskInstance> taskInstances = new ArrayList(pi.getTaskMgmtInstance().getTaskInstances());
		for(TaskInstance ti:taskInstances){
			if(ti.getName().equals(Constants.SUBMIT_REQ)){
				ti.setVariable("userId", userId);
				ti.setVariable("userName",name );
				ti.setVariable("processId",pi.getId());
				ti.end();
				break;
			}
		}
	}
}