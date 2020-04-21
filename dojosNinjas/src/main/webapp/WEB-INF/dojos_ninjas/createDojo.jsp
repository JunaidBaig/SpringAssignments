<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	
	<title>Create a new Dojo</title>
</head>
<body>
	<div class="container">
		<div class="jumbotron jumbotron-fluid">
		
			<a class="btn btn-warning mt-2 mb-2 ml-5" href="/">HOME</a>
			<a class="btn btn-danger" href="/">CANCEL</a>
			
			<h1 class="display-4 text-center">New Dojo</h1>
			
			<form:form action="/dojo/process" method="post" modelAttribute="dojo">
				<p>
					<form:label path="name" class="lead ml-5">Name: </form:label>
					<form:errors path="name" />
					<form:input class="col-10" path="name" />
				</p>
				<input class="btn btn-success mt-2 ml-5" type="submit" value="CREATE" />
			</form:form>
			
		</div>
	</div>
</body>
</html>