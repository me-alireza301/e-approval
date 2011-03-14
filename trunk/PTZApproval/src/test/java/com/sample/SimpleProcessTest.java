package com.sample;

import java.util.List;

import junit.framework.TestCase;

import com.fairfield.rules.vo.ApprovalReviewForm;
import com.fairfield.services.ApprovalFormServiceImpl;
import com.fairfield.services.DeployTask;

public class SimpleProcessTest extends TestCase {

	public void testSimpleProcess() throws Exception {
		//RequestFacilityServiceImpl service = new RequestFacilityServiceImpl();
		//service.init();
		//ApprovalFormServiceImpl appService = new ApprovalFormServiceImpl();
		//appService.submitApprovalForm("U-002","Nancy");
		DeployTask.run();
		/*List<ApprovalSubmitForm> formList =  appService.getApprovalSubmitFormListForHOD();
		for(ApprovalSubmitForm form:formList){
			System.out.println("user id:"+form.getUserId());
			System.out.println("user name:"+form.getUserName());
			System.out.println("process id:"+form.getProcessId());
		}*/
		
		/*ApprovalReviewForm form = appService.getApprovalReviewForm(1);
		System.out.println("user id:"+form.getUserId());
		System.out.println("user name:"+form.getUserName());
		System.out.println("process id:"+form.getProcessId());*/
		//appService.approveSubmittedForm("HOD Zaw Htut approved this", 1);

/*		List<ApprovalReviewForm> formList =  appService.getReviewFormListForAccountant();
		for(ApprovalReviewForm form:formList){
			System.out.println("user id:"+form.getUserId());
			System.out.println("user name:"+form.getUserName());
			System.out.println("remark:"+form.getRemark());
			System.out.println("process id:"+form.getProcessId());
		}*/
	}

}
