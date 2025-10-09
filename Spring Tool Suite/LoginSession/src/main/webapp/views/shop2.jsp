<%@ taglib prefix="it" uri="/WEB-INF/itemtags.tld" %>

<%@page import="java.util.List"%>
<%@page import="com.LogginSession.model.Item"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<form action="${ShowNextShop}" method="GET">
<it:itemCheckboxes items="${Products}" namePrefix="product"/>
<input type="submit" value="go to shop2...">
<input type="hidden" name="NextShop" value="shop3">
<input type="hidden" name="NextShopAction" value="${ShowNextShop}" >

<%-- <br><% out.println(request.getAttribute("ShowNextShop"));%></br>
<br><% out.println(request.getAttribute("ShopCart"));%></br>
 --%>
</body>
</html>