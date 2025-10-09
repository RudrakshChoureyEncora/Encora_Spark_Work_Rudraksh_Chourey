<%@page import="java.util.List"%>
<%@page import="com.myweb.model.Item"%>
<%@page import="com.myweb.services.ItemsServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Shop 1 Products</h1>



<form action="shopping.do" method="post">
<input type="hidden" name="action" value="shopping">
<input type="hidden" name="actionid" value="shopping">
<%
    List<Item> products = (List<Item>) request.getAttribute("Products");
    if (products != null) {
        for (Item item : products) {
%>
    <input type="checkbox" name=<%=item.getItemname()%> value="<%=item.getItemid()%>"/>
    <%=item.getItemname()%> <br/>
<%
        }
    } else {
%>
    <p>No products available.</p>
<%
    }
%>

<input type="submit" value="Go To Cart..."/>
</form>

<a href="Welcome.do?actionid=GoToHome">Go To Home</a>

</body>
</html>