<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="/navigation"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Incident</title>
</head>
<body>
	<div class="container">
		<form:form modelAttribute="incident" method="post" action='incident/${incident.id}'>
			<form:errors path="*" element="div"></form:errors>

			<div class="form-group">
				<label for=description>Description</label>
				<form:input type="text" class="form-control" id="description"
					placeholder="Enter description" name="description"
					path="description" />
			</div>
			<div class="form-group">
				<label for="priority">Priority</label>
				<form:select path="priority" class="form-control"
					items="${priorityList}" selected="${ priority }" />
			</div>

			<div class="form-group">
				<label for="category">Category</label>
				<form:select path="category" class="form-control"
					items="${categories}" />
			</div>

			<div class="form-group">
				<label for="department">Departments</label>
				<form:select path="department.name" class="form-control"
					items="${departments}" />
			</div>

			<div class="form-group">
				<label for="possibleCause">Possible Cause</label>
				<form:input type="text" class="form-control" id="possibleCause"
					placeholder="Enter possibleCause" name="possibleCause"
					path="possibleCause" />
			</div>
			<div class="form-group">
				<label for="suggestion">Suggestion</label>
				<form:input type="text" class="form-control" id="suggestion"
					placeholder="Enter suggestion" name="suggestion" path="suggestion" />
			</div>
			<form:input path="createdDate" type="date" style="display: none;" />
			<form:input path="updatedDate" type="date" style="display: none;" />
			<button type="submit" class="btn btn-default">Save</button>
		</form:form>
	</div>
</body>
</html>