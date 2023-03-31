<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
<%@include file="/resources/css/table.css"%>
</style>
<script type="text/javascript">
	function doDelete(id) {
		if(confirm("are you sure to delete Student with ID="+id)){
			window.location="delete?id="+id;	
		}
	}
</script>
</head>
<body>
	<div id="container">
		<h2>List of Students</h2>
		<div style="text-align: center;">
			<a href="add.jsp"> <img alt="Add Student"
				src="https://cdn-icons-png.flaticon.com/512/992/992651.png"
				class="img_add">
			</a>
		</div>
		<ul class="responsive-table" style="padding: 0">
			<li id="table-header" style="background-color: #c0c0c0;">
				<div class="col col-1">ID</div>
				<div class="col col-2">NAME</div>
				<div class="col col-3">AGE</div>
				<div class="col col-4">CLASS</div>
				<div class="col col-5">FEATURE</div>
			</li>
			<c:forEach items="${requestScope.dataStudent}" var="c">
				<c:set var="id" value="${c.idStudent}" />
				<li class="table-row">
					<div class="col col-1">${id}</div>
					<div class="col col-2">${c.name}</div>
					<div class="col col-3">${c.age}</div>
					<div class="col col-4">${c.classStudent}</div>
					<div class="col col-5">
						<a href="update?id=${id	}" class="tow" >Update</a>
						<a href="#" class="tow" onclick="doDelete('${id}')">Delete</a>
					</div>
				</li>
			</c:forEach>
		</ul>
	</div>

</body>
</html>