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
<h1>This is shop2</h1>
<form action="shopping.do" method="post">

<%
    List<Item> products = (List<Item>) request.getSession().getAttribute("Shop2Prod");
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


<input type="hidden" name="actionid" value="shopping">
<input type="hidden" name="next" value="shop3">
<input type="submit" value="Go To Next Shop..."/>
</form>

<%
    Cart cart = (Cart) request.getSession().getAttribute("Cart");
	List<CartItem> ci=cart.getListOfItems();
	
	  for (CartItem c : ci) {
	    	System.out.println(c.getItem().getItemname());
	        out.println("<br>"+"----- Item Name: " + c.getItem().getItemname() + 
	                    " ----- Item Price: " + c.getItem().getItemprice() + 
	                    " ----- Item Quantity: " + c.getQuantity() + 
	                    " ----- Total Price: " + (c.getItem().getItemprice() * c.getQuantity()) + "<br>");
	    }

	    out.println("<br>--------------- Total Price of the Cart: " + cart.getTotalPrice() + "/- ---------------------------------------<br>");

%>


</body>
</html>