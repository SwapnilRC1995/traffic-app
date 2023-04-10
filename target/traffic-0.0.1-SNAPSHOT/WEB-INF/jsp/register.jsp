<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<form action="/register" method="post" class="container mt-5">
		<div class="mb-3">
			<label for="exampleInputEmail1" class="form-label">Username</label> <input
				type="text" class="form-control" id="exampleInputEmail1"
				aria-describedby="emailHelp" name="username">
			<div id="emailHelp" class="form-text">We'll never share your
				email with anyone else.</div>
		</div>
		<div class="mb-3">
			<label for="exampleInputPassword1" class="form-label">Password</label>
			<input type="password" class="form-control"
				id="exampleInputPassword1" name="password">
		</div>
		<div class="mb-3">
			<label for="exampleInputPassword1" class="form-label">Driving
				license number</label> <input type="number" class="form-control"
				id="exampleInputPassword1" name="license">
		</div>
		<div class="mb-3">
			<label for="exampleInputPassword1" class="form-label">Full
				name</label> <input type="text" class="form-control"
				id="exampleInputPassword1" name="name">
		</div>
		<div class="mb-3">
			<label for="exampleInputPassword1" class="form-label">Address</label>
			<input type="text" class="form-control" id="exampleInputPassword1"
				name="address">
		</div>
		<div class="mb-3">
			<label for="exampleInputPassword1" class="form-label">Gender</label>
			<select class="form-select" aria-label="Default select example"
				name="gender">
				<option selected disabled="disabled">Select gender</option>
				<option value="MALE">Male</option>
				<option value="FEMALE">Female</option>
			</select>
		</div>
		<div class="mb-3">
			<label for="exampleInputPassword1" class="form-label">Date of
				birth</label> <input type="date" class="form-control"
				id="exampleInputPassword1" name="dob">
		</div>
		<div class="mb-3">
			<p style="color: red;">${error}</p>
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
</body>
</html>