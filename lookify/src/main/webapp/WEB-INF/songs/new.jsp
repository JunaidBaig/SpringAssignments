<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<a href="/dashboard"> Dashboard </a>  
	<h1>Add New Song</h1>
	<form:form action="/dashboard/" method="post" modelAttribute="song">
    <p>
        <form:label path="title">Title</form:label>
        <form:errors path="title"/>
        <form:input path="title"/>
    </p>
    <p>
        <form:label path="artist">Artist</form:label>
        <form:errors path="artist"/>
        <form:textarea path="artist"/>
    </p>
    <p>
        <form:label path="Rating">Rating</form:label>
        <form:errors path="Rating"/>
        <form:input path="Rating"/>
    </p>
        
    <input type="submit" value="Add Song"/>
	</form:form>

</body>
</html>