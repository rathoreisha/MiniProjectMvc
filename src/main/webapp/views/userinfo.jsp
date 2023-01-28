<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>www.IshaIT.com</title>
</head>
<body bgcolor='pink' align='center'>
<h3 style="color:#C62FD1; font-size:40px;"> save contact Here</h3>

<font color='green'> ${success} </font>
<font color='red'> ${fail} </font>


<form:form   action="userLogin? id=${userInfo.id}"  modelAttribute="userInfo" method="POST">


<table align='center' border='3'>
<tr>
<td>User Name</td>
<td><form:input path="name"/></td>
</tr>

<tr>
<td>Password</td>
<td><form:input path="password"/></td>
</tr>

<tr>
<td>Role</td>
<td><form:input path="role"/></td>
</tr>

<tr>
<td ><input style="color:darkgreen; align:center;"  type="submit"  value="Save"/></td>
</tr>


</table>
<!--  <a href="viewContact" style="color:yellow; font-size:20px;"> View All Contact</a>-->
</form:form>
</body>
</html>