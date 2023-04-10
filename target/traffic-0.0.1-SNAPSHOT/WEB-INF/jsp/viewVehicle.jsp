<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-primary mb-4">
		<div class="container-fluid">
			<a class="navbar-brand text-white" href="/dashboard">Online
				Traffic Ticket Portal</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
				aria-controls="navbarNavAltMarkup" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
				<div class="navbar-nav">
					<a class="nav-link active text-white" aria-current="page"
						href="/register-vehicle">Register vehicle</a> <a
						class="nav-link text-white" href="/view-vehicles">View
						vehicles</a>
				</div>
			</div>
		</div>
	</nav>
	<div class="container">
		<table class="table-striped">
			<thead>
				<tr>
					<th>Vehicle number</th>
					<th>Brand</th>
					<th>Type</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="vehicle" items="${vehicles}">
					<tr>
						<td>${vehicle.vehicleId }</td>
						<td>${vehicle.brand }</td>
						<td>${vehicle.type }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>