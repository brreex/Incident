<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<jsp:include page="/navigation"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<div class="container">
		<form:form modelAttribute="solution" method="post" action='/solution/1'>
			<form:errors path="*" element="div"></form:errors>
			<div class="form-group">
				<label for=description>Description</label>
				<form:input type="text" class="form-control" id="description"
					placeholder="Enter description" name="description"
					path="description" />
			</div>
			<button type="submit" class="btn btn-default">Save</button>
		</form:form>
	</div>
</body>
</html>