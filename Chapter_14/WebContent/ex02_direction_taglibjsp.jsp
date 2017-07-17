<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
	<ul>
	<core:forEach var="i" begin="0" end="10">
		<li>${i }번째 행</li>
	</core:forEach>
	</ul>
	<hr>
	<ul>
	<%
		for(int i=0; i <= 10; i++){
	%>	
		<li><%=i+10 %>번째 행</li>
	<%	
		}
	%>
	</ul>
</body>
</html>