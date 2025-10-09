<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>We Are at Home....</h1>
<%
Enumeration<String> e= request.getAttributeNames();

while(e.hasMoreElements()){
	String s=e.nextElement();
	out.println("<br>"+"Attribute of Request:"+ s+"   has Value: "+request.getAttribute(s)+"</br>");
}

e=request.getSession().getAttributeNames();
while(e.hasMoreElements()){
	String s=e.nextElement();
	out.println("<br>"+"Attribute of Session:"+ s+"   has Value: "+request.getSession().getAttribute(s)+"</br>");
}
%>

</body>
</html>