<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
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
		<h2>Your violations: </h2>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Notice number</th>
					<th>Vehicle number</th>
					<th>Brand</th>
					<th>Type</th>
					<th>Description</th>
					<th>Fine(in CAD)</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="violation" items="${violations}">
					<tr>
						<td>${violation.noticeNumber }</td>
						<td>${violation.vehicle.vehicleId }</td>
						<td>${violation.vehicle.brand }</td>
						<td>${violation.vehicle.type }</td>
						<td>${violation.description }</td>
						<td>${violation.fine }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>