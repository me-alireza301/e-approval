<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Requests Pending for HOD</title>
<jsp:include page="css_include.jsp"></jsp:include>
<link rel="stylesheet"  type="text/css" href="<%=request.getContextPath()%>/css/displaytag.css"/>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<div id="content">
<display:table name="processList" requestURI="/list-approved-forms.do" 
      				id="reviewForm" uid="reviewForm"  excludedParams="*"    
      				class="displaytag" cellpadding="0" style="width:800px" pagesize="20">
           		<display:column title="User ID" ><a href="show-review-form.do?processId=${reviewForm.processId}">${reviewForm.userId}</a></display:column>
           		<display:column title="User Name" property="userName"/>
</display:table>
</div>
</body>
</html>