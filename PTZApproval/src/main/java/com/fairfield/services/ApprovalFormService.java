package com.fairfield.services;

import java.util.List;

import com.fairfield.rules.vo.ApprovalReviewForm;
import com.fairfield.rules.vo.ApprovalSubmitForm;

public interface ApprovalFormService {
	public String submitApprovalForm(String userId, String name) ;
	public List<ApprovalSubmitForm> getApprovalSubmitFormListForHOD();
	public ApprovalReviewForm getApprovalReviewForm(long processId);
	public void approveSubmittedForm(String remark,long processId) ;
	public List<ApprovalReviewForm> getReviewFormListForAccountant();
}
