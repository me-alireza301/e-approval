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
public class AccountantAction {
	
	@Autowired
	ApprovalFormService approvalFormService;
	
	@RequestMapping(value="/submit-request.do",method=RequestMethod.GET)
	public String showSubmitRequest(HttpServletRequest request) throws Exception{
		request.setAttribute("approvalSubmitForm",new ApprovalSubmitForm());
		return "submit-request-form";
	}
	
	@RequestMapping(value="/submit-request.do",method=RequestMethod.POST)
	public String submitRequest(@ModelAttribute("approvalSubmitForm")ApprovalSubmitForm form,BindingResult bindingResult, HttpServletRequest request, ModelMap model) throws Exception{
		String status = approvalFormService.submitApprovalForm(form.getUserId(),form.getUserName());
		System.out.println(status);
		request.setAttribute("approvalSubmitForm",new ApprovalSubmitForm());
		request.setAttribute("statusMessage",status);
		return "submit-request-form";
	}
	@RequestMapping(value="/list-approved-forms.do",method=RequestMethod.GET)
	public String showApprovedFormList(HttpServletRequest request){
		List<ApprovalReviewForm> processList= approvalFormService.getReviewFormListForAccountant();
		request.setAttribute("processList",processList);
		return "list-approved-forms";
	}
	@RequestMapping(value="/show-review-form.do",method=RequestMethod.GET)
	public String showApproveRequestForm(HttpServletRequest request){
		long processId = Long.parseLong(request.getParameter("processId"));
		ApprovalReviewForm reviewForm = approvalFormService.getApprovalReviewForm(processId);
		request.setAttribute("reviewForm", reviewForm);
		return "review-form";
	}	
	
}
