<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="/navigation"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
					
					<th>Solved By</th>
					<th>Solution Given</th>
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
					<td>${ solution.user.firstname }</td>
					<td>${ solution.description }</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>