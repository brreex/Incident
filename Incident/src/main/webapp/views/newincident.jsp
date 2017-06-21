<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<jsp:include page="/navigation" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<form:form modelAttribute="incident" method="post" action="incident">
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
					items="${priorityList}" />
			</div>

			<div class="form-group">
				<label for="category">Category</label>
				<form:select path="category" class="form-control"
					items="${categories}" />
			</div>

			<%-- <div class="form-group">
			<label for="category">Departments</label>
				<select class="form-control" name="depart" >
					<c:forEach items="${ departments }" var="department">
						<option value="${ department }" selected="${ department }">${ department }</option>
					</c:forEach>
				</select>
			</div> --%>
			
			<div class="form-group">
				<label for="department">Departments</label>
				<form:select path="department.name" class="form-control" items="${departments}"/>
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
			<button type="submit" class="btn btn-default">Create
				Incident</button>
		</form:form>
	</div>
</body>
</html>