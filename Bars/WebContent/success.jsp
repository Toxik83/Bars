<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
 
<head>
<style>
body{background-color:gold}
h1{color:blue}
</style>
</head>
 
<body>
<a href="<s:url action="view.action"/>">Display Records</a>
<br><br>
<b><font color="#5d8122" face="verdana">Insert Details</font></b>
<s:form action="add">
 
<s:textfield label="Name" name="bar.name" />
<s:textfield label="Places" name="bar.places" />
<s:textfield label="Price" name="bar.price" />
 <s:textfield label="Time" name="bar.time"/>
 <s:textfield  label="Address" name="bar.address"/>
<s:submit value="Insert" />
</s:form>
<a href="login.jsp"> To Login</a>
</body>
</html>