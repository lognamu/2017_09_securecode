<%@page import="dao.ScoreDao"%>
<%@page import="vo.ScoreVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String code = request.getParameter("code");
	String name = request.getParameter("name");
	String korean = request.getParameter("korean");
	String english = request.getParameter("english");
	String math = request.getParameter("math");
	
	ScoreVo svo = new ScoreVo();
	svo.setCode(Integer.parseInt(code));
	svo.setName(name);
	svo.setKorean(Integer.parseInt(korean));
	svo.setEnglish(Integer.parseInt(english));
	svo.setMath(Integer.parseInt(math));
	
	ScoreDao.getInstance().update(svo);
	response.sendRedirect("score_list.jsp");
%>