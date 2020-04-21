<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	
	<title>Create a new Ninja</title>
</head>
<body>
	<div class="container">
		<div class="jumbotron jumbotron-fluid">
			<a class="btn btn-warning mt-2 mb-2 ml-5" href="/">HOME</a>
			
			<a class="btn btn-danger" href="/">CANCEL</a>
			<h1 class="display-4 text-center">New Ninja</h1>
		
			
			<form:form action="/ninja/process" method="post" modelAttribute="ninja">
				<p>
					<form:label path="dojo" class="ml-5">Dojo: </form:label>
					<form:errors path="dojo" />
					<form:select path="dojo">
						<c:forEach items="${dojos}" var="dojo">
							<form:option value="${dojo.id}">
								<c:out value="${dojo.name}"/>
							</form:option>
						</c:forEach>
					</form:select>
				</p>
				
				<p>
					<form:label class="ml-5" path="firstName">First Name: </form:label>
					<form:errors path="firstName" />
					<form:input class="col-7" path="firstName" />
				</p>
				
				<p>
					<form:label class="ml-5" path="lastName">Last Name: </form:label>
					<form:errors path="lastName" />
					<form:input class="col-7" path="lastName" />
				</p>
				
				<p>
					<form:label class="ml-5" path="age">Age: </form:label>
					<form:errors path="age" />
					<form:input  class="col-8" path="age" />
				</p>
				
				<input class="btn btn-success mt-2 ml-5" type="submit" value="CREATE" />
			</form:form>
			
		</div>
	</div>
</body>
</html>