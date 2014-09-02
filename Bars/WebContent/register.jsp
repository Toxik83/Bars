<%@ page language="java" contentType="text/html; charset=ISO-8859-2"
    pageEncoding="ISO-8859-2"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
<title>Registration</title>
<style>
body{background-color:brown}
h1{color:blue}
</style>
</head>
<body>

<br><br>
  
<b><font color="#5d8122" face="verdana">Register Please!</font></b>
<s:form action="register">
 
<s:textfield label="UserName" name="user.username" />
<s:password label="Password" name="user.password" />
<s:submit value="Register" />
</s:form>
</body>
</html>