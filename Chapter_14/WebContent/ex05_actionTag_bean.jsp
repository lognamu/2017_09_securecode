<%@page import="vo.PersonVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%
 	PersonVo vo = new PersonVo();
 	vo.setName("장동혁");
 	vo.setAge(28);
 	vo.setGender("male");
 %> --%>
 
 <jsp:useBean id="pvo" class="vo.PersonVo"></jsp:useBean>
 
<%--  <jsp:setProperty property="name" value="정도전" name="pvo"/>
 <jsp:setProperty property="age" value="600" name="pvo"/>
 <jsp:setProperty property="gender" value="male" name="pvo"/> --%>
 
<%-- <jsp:setProperty property="name" param="name" name="pvo"/>
<jsp:setProperty property="age" param="age" name="pvo"/>
<jsp:setProperty property="gender" param="gender" name="pvo"/> --%>

<%-- <jsp:setProperty property="name" name="pvo"/>
<jsp:setProperty property="age" name="pvo"/>
<jsp:setProperty property="gender" name="pvo"/> --%>

<jsp:setProperty property="*" name="pvo"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<%-- 	이름:<%= vo.getName() %>
	<hr> --%>
	이름:<jsp:getProperty property="name" name="pvo"/><br>
	나이:<jsp:getProperty property="age" name="pvo"/><br>
	성별:<jsp:getProperty property="gender" name="pvo"/>
</body>
</html>