<%@page import="org.springframework.security.core.AuthenticationException"%>
<%@page import="org.springframework.security.web.authentication.AbstractProcessingFilter"%>
<%@page import="org.springframework.security.web.authentication.AuthenticationProcessingFilter"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<jsp:include page="css_include.jsp"></jsp:include>
</head>
<body>
<div id="content">
<h2>Login</h2>
<form action="j_spring_security_check" method="post" id="appForm">
<font size="1px" color="red">${error}</font>
<table>
<tr>
	<td width="100px"<label for="j_username">User Name</label></td>
	<td width="200px"><input id="j_username" name="j_username" type="text" class="appFormInput" /></div></td>
</tr>
<tr>
	<td><label for="j_password">Password</label></td>
	<td><input id="j_password" name="j_password" type="password" class="appFormInput"/></td>
	<td align="left"><input  type="submit" value="Login"/></td>
</tr>
</table>
</form>
</div>
</body>
</html>