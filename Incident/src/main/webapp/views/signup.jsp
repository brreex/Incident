<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<jsp:include page="/navigation"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<form:form modelAttribute="employee" method="post" action="signup">
			<form:errors path="*" element="div"></form:errors>

			<div class="form-group">
				<label for=firstName>First Name</label>
				<form:input type="text" class="form-control" id="firstName"
					placeholder="Enter firstName" name="firstName" path="firstname" />
			</div>

			<div class="form-group">
				<label for="lastName">Last Name</label>
				<form:input type="text" class="form-control" id="lastName"
					placeholder="Enter lastName" name="lastName" path="lastname" />
			</div>

			<div class="form-group">
				<label for="position">Position</label>
				<form:input type="text" class="form-control" id="position"
					placeholder="Enter position" name="position" path="position" />
			</div>
			<div class="form-group">
				<label for="department">Departments</label>
				<form:select path="department.name" class="form-control"
					items="${departments}" />
			</div>
			<div class="form-group">
				<label for="phone">Phone</label>
				<form:input type="text" class="form-control" id="phone"
					placeholder="Enter phone" name="phone" path="phone" />
			</div>
			<div class="form-group">
				<label for="email">Email</label>
				<form:input type="email" class="form-control" id="email"
					placeholder="Enter email" name="email" path="email" />
			</div>
			<div class="form-group">
				<label for="username">User Name</label>
				<form:input type="text" class="form-control" id="username"
					placeholder="Enter username" name="username" path="" />
			</div>
			<div class="form-group">
				<label for="password">Password</label>
				<form:input type="password" class="form-control" id="password"
					placeholder="Enter password" name="password" path="" />
			</div>
			<br>
			<button type="submit" class="btn btn-default">Register</button>
		</form:form>
	</div>
	<!-- /.container -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		type="text/javascript"></script>
</body>
</html>