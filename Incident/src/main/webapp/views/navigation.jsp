<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/">IT Incident</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li><a href="/">Home</a></li>
					<%-- <sec:authorize access="hasRole('ROLE_ADMIN')"> --%>
					<li><a href="/myincidents">My Incidents</a></li>
					<li><a href="/incidents">Incidents</a></li>
					<li><a href="/incident">New Incident</a></li>
					<%-- </sec:authorize> --%>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<%-- <sec:authorize access="hasRole('ROLE_USER')"> --%>
					<li><a href="/profile">Profile</a></li>
					<%-- </sec:authorize> --%>
					<%-- <sec:authorize access="hasRole('ADMIN')"> --%>
					<li><a href="/users">Users</a></li>
					<li><a href="/signup">Register</a></li>
					<%-- </sec:authorize> --%>
					<%-- <sec:authorize access="!hasRole('USER')"> --%>
					<li><a href="/login">Login</a></li>
					<%-- </sec:authorize> --%>
					<%-- <sec:authorize access="hasRole('ROLE_USER')"> --%>
					<li><a href="/logout">Logout</a></li>
					<%-- </sec:authorize> --%>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		type="text/javascript"></script>
</body>
</html>