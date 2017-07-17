<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true"  %>
<%@ page buffer="8kb" %>
<%@ page isThreadSafe="true" %>
<%@ page info="이 페이지는 page지시어를 실습하는 페이지 입니다." %>
<%@ page errorPage="error.jsp" %>
<%-- <%@ page import="java.util.Calendar" %> --%>
<%
	Calendar c = Calendar.getInstance();
	//int number = 100/0;
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
	page연습 JSP
</body>
</html>