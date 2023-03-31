<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
<%@include file="/resources/css/add.css"%>
</style>
</head>
<body>
	<div class="formbold-main-wrapper">
		<h2 style="color: #0000FF;padding: 10px ;text-align: center; margin-bottom: 20px">Form Add Student</h2>
		<div class="formbold-form-wrapper">
			<form action="add" method="POST">
				<div class="formbold-mb-5">
					<label for="id" class="formbold-form-label">ID Student</label> <input
						type="number" name="id" placeholder="Enter your ID Student"
						class="formbold-form-input" />
				</div>
				<div class="formbold-mb-5">
					<label for="name" class="formbold-form-label"> Full Name </label> <input
						type="text" name="name" placeholder="Enter your full Name"
						class="formbold-form-input" />
				</div>
				<div class="formbold-mb-5">
					<label for="phone" class="formbold-form-label">Age</label> <input
						type="number" name="age" placeholder="Enter your age"
						class="formbold-form-input" />
				</div>
				<div class="formbold-mb-5">
					<label for="email" class="formbold-form-label"> Class</label> <input
						type="text" name="class" placeholder="Enter your Class"
						class="formbold-form-input" />
				</div>
				<div>
					<button class="formbold-btn" type="submit">Add Student</button>
				</div>
			</form>
			<h3 style="color: #00FF00;padding: 10px ; text-align: center;">${requestScope.ok}</h3>
			<h3 style="color: #ff0000;padding: 10px ; text-align: center;">${requestScope.err}</h3>
		</div>
	</div>
</body>
</html>