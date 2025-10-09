
<%@page import="com.ShoppingDemo.model.CartItem"%>
<%@page import="com.ShoppingDemo.model.Cart"%>
<%@page import="com.ShoppingDemo.model.Item"%>
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
<h1>welcome to shop1</h1>

<form action="shopping.do" method="post">
<input type="hidden" name="actionid" value="shopping">
<input type="hidden" name="next" value="shop2">
<%
    List<Item> products = (List<Item>) request.getSession().getAttribute("Shop1Prod");
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
<input type="checkbox" >
<input type="submit" value="Go To Next Shop..."/>
</form>

<%
    Cart cart = (Cart) request.getSession().getAttribute("Cart");
	List<CartItem> ci=cart.getListOfItems();
	for(CartItem c:ci) out.println("----- Item Name: "+c.getItem().getItemname()+"----- Item Price: "+c.getItem().getItemprice()+"----Item Quantity: "+c.getQuantity()+"-----total Price: "+(c.getItem().getItemprice()*c.getQuantity()));
	
	
	out.println("---------------Total Price of the cart: "+cart.getTotalPrice()+ "/-  ---------------------------------------");	
	
%>

</body>
</html>