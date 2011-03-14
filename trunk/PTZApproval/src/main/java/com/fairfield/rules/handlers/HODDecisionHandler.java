package com.fairfield.rules.handlers;

import org.jbpm.graph.exe.ExecutionContext;
import org.jbpm.graph.node.DecisionHandler;

import com.fairfield.common.Constants;

public class HODDecisionHandler implements DecisionHandler {

	@Override
	public String decide(ExecutionContext executionContext) throws Exception {
		Boolean hodApproved = (Boolean)executionContext.getContextInstance().getTransientVariable(Constants.HOD_APPROVED);
		System.out.println("HOD Approved:"+hodApproved);
		if(hodApproved)
			return "to Review by Accountant";
		else
			return "to Form Rejected";
	}

}
