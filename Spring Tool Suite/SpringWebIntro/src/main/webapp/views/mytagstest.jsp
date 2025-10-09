

<%@taglib uri="/WEB-INF/mytags.tld" prefix="shoiabstags" %>

${myobjrequest}....:....${myobjrequest2}
From session...:<%=session.getAttribute("myobj") %>
<h1>Welcome page...</h1>x
<shoiabstags:checkNumber num="<%=request.getAttribute(\"number\")%>"/>





