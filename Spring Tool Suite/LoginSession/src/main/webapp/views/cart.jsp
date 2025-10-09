<%@ taglib prefix="ct" uri="/WEB-INF/carttags.tld" %>

<%@page import="com.LogginSession.model.CartItem"%>
<%@page import="com.LogginSession.model.Cart"%>
<%@page import="com.LogginSession.model.Item"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>This is cart</h1>

<form action="/BRC/UpdateCart;jsessionid=<%=session.getId() %>" method="get">

<%-- <%
    Cart cart = (Cart) request.getSession().getAttribute("Cart");
	List<CartItem> ci=cart.getListOfItems();
	out.println("Total Number of Items: "+ci.size());

	  for (CartItem c : ci) {
	    	System.out.println(c.getItem().getItemname());
	        out.println("<br>"+"----- Item Name: " + c.getItem().getItemname() + 
	                    " ----- Item Price: " + c.getItem().getItemprice() + 
	                    " ----- Item Quantity: " + c.getQuantity() + 
	                    " ----- Total Price: " + (c.getItem().getItemprice() * c.getQuantity()) + "<br>");
	    }

	    out.println("<br>--------------- Total Price of the Cart: " + cart.getTotalPrice() + "/- ---------------------------------------<br>");

%> --%>

<ct:CartPrint cart="${sessionScope.Cart}"/>



<input type="hidden" name="NextShop" value="cart">
<input type="submit" value="Update Cart..."/>
</form>


<form action="${ShowNextShop}" method="get">
<input type="hidden" name="NextShop" value="invoice">
<input type = "submit" value="Generate Invoice...">
</form>
</body>
</html>