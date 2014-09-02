<%-- This JSP displays the rows from a table to the user.They can't be changed.
looks at every element at the list and displays every value for every property.--%>

<%@ taglib uri="/struts-tags" prefix="s" %>  
  <style>
body{background-color:silver}
h1{color:blue}
</style>
<h3>All Records:</h3>  
<s:iterator  value="list">  
<fieldset>  
<s:property value="name"/><br/>  
<s:property value="places"/><br/>  
<s:property value="price"/><br/>  
<s:property value="time"/><br/>  
<s:property value="address"/><br/>  
</fieldset>  
</s:iterator>  
<a href="login.jsp">To login </a>
