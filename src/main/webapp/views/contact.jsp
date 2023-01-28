<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>www.IshaIt</title>
<script>
function confirmDelete()
{
	return confirm("Are u sure you want to delete?");
	}
</script>
</head>
<form>
<body bgcolor='pink' align='center'>
<h1 align='center'>View All Contacts</h1>

	<table border='5' align='center'>
		<tr >
			<th>Name</th>
			<th>Email</th>
			<th>Number</th>
		</tr>

		<tbody>
			<c:forEach items="${contact}" var = "cot">
				<tr>
					<td>${cot.contactName}</td>
					<td>${cot.contactEmail}</td>
					<td>${cot.contactNumber}</td>
					<td><a href="edit?contactId=${cot.contactId }"><label style="color: Green;font-size:20px;">EDIT</label></a></td>
					<td><a href="delete?contactId=${cot.contactId }" onclick="return confirmDelete()">
					<label style="color: Red;font-size:20px;">Delete</label></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

<a  align='center' href="ContactPage" >signup</a>
</form>
</body>
</html>