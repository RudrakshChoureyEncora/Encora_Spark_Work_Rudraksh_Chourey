<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<form:form action="${LoginAction}" method="POST" modelAttribute="userObj">
	UserName:<form:input path="userid"/>
	<form:errors path="userid"></form:errors><br>
	PassWord:<form:input path="userpass"/><br>
	<input type="submit" value="Try Login">
		<%-- <% out.println(request.getAttribute("LoginAction")); %> --%>
</form:form>
