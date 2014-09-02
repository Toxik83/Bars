<%@ page language="java" contentType="text/html; charset=ISO-8859-2"
    pageEncoding="ISO-8859-2"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
<title>Login</title>
<style>
body{background-color:gold}
h1{color:blue}
</style>
</head>
<body>
<%-- This JSP uses element form and sends data to the server.The data from the fields are
send to the JavaBean User --%>
					<s:form action="login" style="text-align:right">
						<s:textfield name="user.username" label="UserName"></s:textfield>
						<s:password name="user.password" label="Password"></s:password>
						<s:submit value="login"></s:submit>
</s:form>
<%-- This is a link to another jsp --%>
<a href="register.jsp">Registration</a>
</body>
</html>