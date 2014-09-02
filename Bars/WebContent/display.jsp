<%-- This JSP uses JavaScript functions,that reads the the number of the row
and then acts accordingly (Delete or Edit) --%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="java.util.*;" %>

<head>
<style>
body{background-color:gold}
h1{color:blue}
</style>
<script type="text/javascript">
function deleteRecord()
{
document.form.action="delete.action";
document.form.submit();
}
function editrecord(val)
{
document.form.action="update.action?fid="+val;
document.form.submit();
}
</script>
</head>
 
<a href="<s:url action="saveLink.action"/>">Insert</a>
 
<br><br>
 
<table>
<form name="form" method="post">
<%
List l=(List)request.getAttribute("display");
if(l!=null)
{
 
Iterator it=l.iterator();
 
while(it.hasNext())
{
 
action.Bar bar=(action.Bar)it.next();
int tempNum = bar.getBar_id();
String tempName = bar.getName();
int places = bar.getPlaces();
int price=bar.getPrice();
String time = bar.getTime();
String address=bar.getAddress();

%>
<table border="1">
<tr>
<td><input type="checkbox" value="<%= tempNum %>" name="rowdelete"></td>
<td><%= tempNum %></td>
<td><%= tempName %></td>
<td><%= places %></td>
<td><%=price %></td>
<td><%=time %></td>
<td><%=address %> </td>
<td><a href="javascript:editrecord('<%= tempNum %>')">Edit</a></td>
</tr>
 
<%
 
}
}
 
%>
<input type="button" value="delete" onclick="deleteRecord();">
</table>
</form>
<a href="login.jsp"> To Login</a>