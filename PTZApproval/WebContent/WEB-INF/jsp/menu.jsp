<%@page import="org.springframework.security.core.GrantedAuthority"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.fairfield.common.Constants"%>
<%@page import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@page import="com.fairfield.rules.vo.UserProfile"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
UserProfile profile = (UserProfile)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
ArrayList<GrantedAuthority> list = new ArrayList<GrantedAuthority>(profile.getAuthorities()); 
String roleCode = list.get(0).getAuthority();
%>
<div id="menu">
				<%if(roleCode.equals(Constants.ROLE_ACCOUNTANT)){ %>
					<a href="submit-request.do">Submit Form</a>
					<a href="list-approved-forms.do">View Approved Forms</a>
				<%} %>
				<%if(roleCode.equals(Constants.ROLE_HOD)){ %>
					<a href="list-for-hod.do">View Submitted Forms</a>
				<%} %>	
					<a href="logout.do">Logout</a>				
</div>