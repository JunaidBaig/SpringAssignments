<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	
	<title>Read One Dojo And View Their Ninjas</title>
</head>
<body>
	<div class="container">
		<div class="jumbotron jumbotron-fluid">
			<a class="btn btn-warning mb-2 ml-2" href="/">HOME</a>
			<a class="btn btn-success mb-2" href="/ninjas/new">ADD NINJA</a>
			
			<h1 class="display-4 text-center"><c:out value="${dojo.name}"/>'s Ninjas</h1>
			
			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th scope="col">First Name</th>
						<th scope="col">Last Name</th>
	 					<th scope="col">Age</th>
						<th scope="col">Action</th>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach items="${dojo.ninjas}" var="ninja">
						<tr>
							<td><c:out value="${ninja.firstName}"/></td>
							<td><c:out value="${ninja.lastName}"/></td>
							<td><c:out value="${ninja.age}"/></td>
							<td><form action="/ninjas/${ninja.id}" method="post">
				    				<input type="hidden" name="_method" value="delete">
				    				<input class="btn btn-danger" type="submit" value="DELETE">
								</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			
			</table>
			
		</div>
	</div>
</body>
</html>