<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String[] cityArr = {"서울", "대전", "대구", "부산"};
	pageContext.setAttribute("cityArr", cityArr);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
	<c:forEach begin="2" end="9" var="i"> <!-- 이때 i가 forEach의 scope소속이 된다 -->
		5 x ${i } = ${i*5 }<br>
	</c:forEach>
	
	<ul>
	<%
		for(String city: cityArr){
	%>
		<li><%=city %></li>
	<%		
		}
	%>
	</ul>
	<hr>
	<ul>
		<c:forEach items="${pageScope.cityArr}" var="city">
			<li>${city }</li>
		</c:forEach>
	</ul>
	
	<c:if test="${param.user == null}">
		로그인하세요<br>
	</c:if>
	<c:if test="${param.user != null}">
		${param.user }님 안녕하세요?<br>
	</c:if>
	
	<c:if test="${!empty param.number}">
		<fmt:formatNumber type="currency" currencySymbol="#" value="${param.number }"/><br>
		<fmt:formatNumber type="number" value="${param.number }"/><br>
	</c:if>
	<%
		pageContext.setAttribute("date", new Date());
	%>
	<fmt:formatDate type="date" pattern="yyyy-MM-dd" value="${date }"/>    
	
	
</body>
</html>