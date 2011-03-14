<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Get Permission to use Operating Theatre</title>
<jsp:include page="css_include.jsp"></jsp:include>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<div id="content">
<p align="left"></strong><font color="blue">${statusMessage}</font></strong></p>
<form:form modelAttribute="reviewForm" action="approve-request.do" method="POST">
<form:hidden path="processId"/>
<table width="67%" border="0" align="left">
  <tr>
    <td width="30%"><strong>User Id:</strong></td>
    <td width="286"><label for="textfield"></label>
     <strong>${reviewForm.userId}</strong>
    </td>
  </tr>
  <tr>
    <td width="30%"><strong>User Name:</td>
    <td width="286"><label for="textfield"></label>
    <strong> ${reviewForm.userName}</strong>
    </td>
  </tr>  
  <tr>
    <td width="30%"><strong>Remark:</td>
    <td width="286"><label for="textfield"></label>
      <strong>${reviewForm.remark}</strong>
    </td>
  </tr>  
  <tr>
</table>
</form:form>
</div>
</body>
</html>