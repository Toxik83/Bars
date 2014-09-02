<%-- This JSP displays the old values of the row,that the user want to change.They are placed
in the  application.The code uses EL to display the values and the values from the map. --%>
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
  
<b><font color="#5d8122" face="verdana">Update Details</font></b>
 
<s:form action="edit">
 
<s:textfield label="ID" value="%{#application.a}" name="bar.bar_id" readonly="true" />
<s:textfield label="Name" value="%{#application.b}" name="bar.name" />
<s:textfield label="Places" value="%{#application.c}" name="bar.places" />
 <s:textfield label="Price" value="%{#application.d}" name="bar.price" />
 <s:textfield label ="Time" value="%{#application.e}" name="bar.time"/>
  <s:textfield label ="Address" value="%{#application.f}" name="bar.address"/>
<s:submit value="Update" />
</s:form>
 <a href="success.jsp"> Save</a> <a href="login.jsp">To Login</a>
</body>
</html>