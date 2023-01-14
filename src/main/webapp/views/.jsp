<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WWW.IshaIT.com</title>
</head>
<body>
<h3>Save Contact Here</h3>

<font color='green'>${success }</font>
<font color='red'>${error }</font>

<form:form action="saveContact? contactId=${contact.contactid}" modelAttribute="contact" method="POST">

<table>
<tr>
<td>Contact Name</td>
<td><form:input path="contactName"/></td>
</tr>

<tr>
<td>Contact Number</td>
<td><form:input path="contactNumber"/></td>
</tr>

<tr>
<td>Contact Email</td>
<td><form:input path="contactEmail"/></td>
</tr>

<tr>
<td><input type="submit"  value="Save"/></td>
</tr>


</table>

</form:form>
<table>
</table>
</body>
</html>