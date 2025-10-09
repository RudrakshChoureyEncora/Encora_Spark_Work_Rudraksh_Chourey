
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome</h1>

<form action="${Shop1ButAction}"  method="GET">

<input type="hidden" name="NextShop" value="shop1">
<input type="hidden" name="NextShopAction" value="${Shop1ButAction}" >
<input type="submit" value="go to shop1...">
<%-- <%
out.println(request.getAttribute("Shop1ButAction"));
%>>
 --%>
</body>
</html>