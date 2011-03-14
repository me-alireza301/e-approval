package com.fairfield.services.helpers.commands;

import java.util.ArrayList;
import java.util.List;

import org.jbpm.graph.exe.ProcessInstance;
import org.jbpm.taskmgmt.exe.TaskInstance;

import com.fairfield.common.Constants;

public class ApproveSubmitFormCommand implements IFormCommand {
	private String remark;
	private ProcessInstance pi;
	
	public ApproveSubmitFormCommand(String remark, ProcessInstance pi) {
		this.remark = remark;
		this.pi = pi;
	}

	@Override
	public void execute() {
		List<TaskInstance> taskInstances = new ArrayList(pi.getTaskMgmtInstance().getTaskInstances());
		for(TaskInstance ti:taskInstances){
			if(ti.getName().equals(Constants.PENDING_FOR_HOD)){
				ti.setVariable("remark",remark);
				pi.getContextInstance().setTransientVariable(Constants.HOD_APPROVED,true);
				ti.end();
				break;
			}
		}
	}

}