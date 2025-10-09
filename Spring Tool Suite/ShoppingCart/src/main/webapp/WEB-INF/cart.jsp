<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Your Shopping Cart</title>
<style>
    body {
        background-color: #ffe6e6;
        font-family: Arial, sans-serif;
    }
    h1 {
        color: #990000;
    }
    ul {
        list-style-type: square;
        font-size: 18px;
    }
</style>
</head>
<body>

<h1>Your Shopping Cart</h1>

<%
    Enumeration<String> e = session.getAttributeNames();
    boolean hasItems = false;
%>

<ul>
<%
    while (e.hasMoreElements()) {
        String name = e.nextElement();
        Object value = session.getAttribute(name);

        // Optionally filter out unrelated attributes, if needed
        if (value instanceof String) {
            hasItems = true;
%>
    <li><%= value %></li>
<%
        }
    }

    if (!hasItems) {
%>
    <li>No items in your cart.</li>
<%
    }
%>
</ul>

</body>
</html>
