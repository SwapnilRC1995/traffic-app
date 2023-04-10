<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<form action="/register-vehicle" method="post" class="container mt-5">

		<div class="mb-3">
			<label for="exampleInputPassword1" class="form-label">Vehicle
				number</label> <input type="text" class="form-control"
				id="exampleInputPassword1" name="vehicle">
		</div>
		<div class="mb-3">
			<label for="exampleInputPassword1" class="form-label">Brand</label> <input
				type="text" class="form-control" id="exampleInputPassword1"
				name="brand">
		</div>
		<div class="mb-3">
			<label for="exampleInputPassword1" class="form-label">Type</label> <select
				class="form-select" aria-label="Default select example" name="type">
				<option selected disabled="disabled">Select gender</option>
				<option value="Hatchback">Hatchback</option>
				<option value="Sedan">Sedan</option>
				<option value="MUV">MUV</option>
				<option value="SUV">SUV</option>
				<option value="Coupe">Coupe</option>
				<option value="Convertible">Convertible</option>
				<option value="Pickup Truck">Pickup Truck</option>
			</select>
		</div>
		<div class="mb-3">
			<p style="color: red;">${error}</p>
		</div>
		<button type="submit" class="btn btn-primary">Add vehicle</button>
	</form>
</body>
</html>