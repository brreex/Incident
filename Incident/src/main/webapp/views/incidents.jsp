<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Incidents</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>

	<div class="container">

		<table class="table table-condensed">
			<thead>
				<tr>
					<th>Description</th>
					<th>Priority</th>
					<th>Status</th>
					<th>Category</th>
					<th>Possible Cause</th>
					<th>Suggestion</th>
					<th>Created Date</th>
					<th>Updated Date</th>
					<th>Created By</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ incidents }" var="incident">
					<tr>
						<td>${incident.description}</td>
						<td>${incident.priority}</td>
						<td>${incident.status}</td>
						<td>${incident.category}</td>
						<td>${incident.possibleCause}</td>
						<td>${incident.suggestion}</td>
						<td>${ incident.createdDate}</td>
						<td>${incident.updatedDate}</td>
						<td>${ incident.user.username}</td>
						<td>
						<form:form action='/incident/${incident.id}'method="get">
							<input type="submit" value="Resolve" />
						</form:form>
						</td>
						<td>
						<form:form action='/incident/${incident.id}' method="get">
							<input type="submit" value="Edit" />
						</form:form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>