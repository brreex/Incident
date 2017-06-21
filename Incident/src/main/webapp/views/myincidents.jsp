<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="/navigation"></jsp:include>
<!DOCTYPE html >
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
					<form:form action='/incident/${incident.id}' method="delete"> 
						<input type="submit" value="Delete"/>
					</form:form>
					</td>
					<td>
					<form:form action='/incident/${incident.id}' method="get">
						<input type="submit" value="Edit"/>
					</form:form>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>