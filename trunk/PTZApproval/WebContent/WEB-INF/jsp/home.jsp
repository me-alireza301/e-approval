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
<body id="page1">
<jsp:include page="menu.jsp"></jsp:include>
<div id="content">            
                <section id="content">
                        <article class="col1">
                            <h2>Welcome to PTZ Approval!</h2>
                            <p><strong>JBPM,JPA,Spring-MVC,Spring,MYSQL</strong></p>
                                <li class="under">
                                    <span class="dropcap_1">1</span>
                                    <span class="colored_ins">The accountant submit the request.</span>
                                </li>
                                <li>
                                    <span class="dropcap_1">2</span>
                                    <span class="colored_ins">The HOD approve the request.</span>
                                </li>
                                <li>
                                    <span class="dropcap_1">3</span>
                                    <span class="colored_ins">The Accountant view the apporoved requests.</span>
                                </li>
                            </ul>
                        </article>
                </section>
</body>
</html>