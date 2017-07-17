<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = "홍길동";
	request.setAttribute("name", name);
%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
	메인페이지
	<%@ include file="sub1.jsp" %>
	<hr>
	<%-- <jsp:include page="sub2.jsp"></jsp:include> --%>
</body>
</html>