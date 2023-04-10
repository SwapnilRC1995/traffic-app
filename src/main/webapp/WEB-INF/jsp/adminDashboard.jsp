<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/admin-dashboard" method="post" class="container mt-5">
		<div class="mb-3">
			<p style="color:green;">${notification }</p>
		</div>
		<div class="mb-3">
			<label for="exampleInputPassword1" class="form-label">Driver</label>
			<select class="form-select" aria-label="Default select example"
				name="driver">
				<option selected disabled="disabled">Select driver</option>
				<c:forEach var="driver" items="${drivers}">
					<option value=${driver.licenseNumber}>${driver.fullName}</option>
				</c:forEach>
			</select>
		</div>
		<div class="mb-3">
			<label for="exampleInputPassword1" class="form-label">Vehicle</label>
			<select class="form-select" aria-label="Default select example"
				name="vehicle">
				<option selected disabled="disabled">Select vehicle</option>
				<c:forEach var="vehicle" items="${vehicles }">
					<option value="${vehicle.vehicleId}">${vehicle.brand} - ${vehicle.type }</option>
				</c:forEach>
			</select>
		</div>
		<div class="mb-3">
			<label for="exampleInputPassword1" class="form-label">Description</label>
			<input type="text" class="form-control" id="exampleInputPassword1"
				name="description">
		</div>
		<div class="mb-3">
			<label for="exampleInputPassword1" class="form-label">Fine</label> <input
				type="number" class="form-control" id="exampleInputPassword1"
				name="fine">
		</div>
		<div class="mb-3">
			<p style="color: red;">${error}</p>
		</div>
		<button type="submit" class="btn btn-primary">Add violation
			ticket</button>
	</form>
</body>
</html>