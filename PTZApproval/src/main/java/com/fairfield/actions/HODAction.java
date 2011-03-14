package com.fairfield.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fairfield.rules.vo.ApprovalReviewForm;
import com.fairfield.rules.vo.ApprovalSubmitForm;
import com.fairfield.services.ApprovalFormService;

@Controller
public class HODAction {
	@Autowired
	ApprovalFormService approvalFormService;
	
	@RequestMapping(value="/list-for-hod.do",method=RequestMethod.GET)
	public String showListForHOD(HttpServletRequest request){
		List<ApprovalSubmitForm> processList= approvalFormService.getApprovalSubmitFormListForHOD();
		request.setAttribute("processList",processList);
		return "list-for-hod";
	}
	@RequestMapping(value="/show-approve-request.do",method=RequestMethod.GET)
	public String showApproveRequestForm(HttpServletRequest request){
		long processId = Long.parseLong(request.getParameter("processId"));
		ApprovalReviewForm reviewForm = approvalFormService.getApprovalReviewForm(processId);
		request.setAttribute("reviewForm", reviewForm);
		return "approve-request-form";
	}
	@RequestMapping(value="/approve-request.do",method=RequestMethod.POST)
	public String approveRequestForm(@ModelAttribute("reviewForm")ApprovalReviewForm form,BindingResult bindingResult, HttpServletRequest request, ModelMap model) throws Exception{
		approvalFormService.approveSubmittedForm(form.getRemark(),form.getProcessId());
		return showListForHOD(request);
	}
	
	/*@RequestMapping(value="/list-all-forms.do",method=RequestMethod.GET)
	public String showAllForms(HttpServletRequest request){
		List<RequestProcess> processList= requestFacilityService.getAllProcess();
		request.setAttribute("processList",processList);
		return "list-all-forms";
	}

	@RequestMapping(value="/hod-reject-request.do")
	public String hodReject(@RequestParam(value="id",required=false)int id,HttpServletRequest request){
		requestFacilityService.hodReject(id);
		return showListForHOD(request);
	}*/
}