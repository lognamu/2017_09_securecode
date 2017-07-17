<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resource/css/style.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
	function editBlocklist(){
		var blocklist = $("#blocklist").val();
		location.href = "/bbs/editBlocklist.do?blocklist="+blocklist;
	}
	function editBlockpage(){
		var blockpage = $("#blockpage").val();
		location.href = "/bbs/editBlockpage.do?blockpage="+blockpage;
	}
</script>
</head>
<body>
	<div class="main">
		<div class="header">
			<h3>| 자유게시판 |</h3>
			<jsp:include page="/bbs/search.jsp"/>
		</div>
		<div class="body">
			<table class="center">
				<tr style="height:30px">
					<th width="10%">번호</th>
					<th width="45%">제목</th>
					<th width="15%">글쓴이</th>
					<th width="15%">날짜</th>
					<th width="15%">조회수</th>
				</tr>
				<c:if test="${empty list}">
					<tr>
						<td colspan="5">
							<b>게시물이 존재하지 않습니다.</b>					
						</td>
					</tr>
				</c:if>
				<c:forEach var="vo" items="${list }">
					<tr>
						<td width="10%">${vo.rownum }</td>
						<td width="45%" style="text-align: left;">
							<c:forEach var="index" begin="1" end="${vo.depth }">
								<c:if test="${index == vo.depth}">└▶</c:if>
								<c:if test="${index != vo.depth}">&nbsp&nbsp&nbsp&nbsp</c:if>
							</c:forEach>
							<a href="/bbs/view.do?idx=${vo.idx }&page=${param.page}">${vo.title }</a>
						</td>
						<td width="15%">${vo.name }</td>
						<td width="15%">${vo.regdate }</td>
						<td width="15%">${vo.hit }</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="footer">
			<div class="page">
				${paging }
			</div>
			<!-- 페이지 -->
			<div class="page">
				<table class="left">
					<tr>
						<th>게시글/화면</th>
						<td>
							<input id="blocklist">
						</td>
						<td>
							 <input type="button" value="적용" onclick="editBlocklist()">
						</td>
					</tr>
					<tr>
						<th>페이지/화면</th>
						<td>
							<input id="blockpage">
						</td>
						<td>
							 <input type="button" value="적용" onclick="editBlockpage()">
						</td>
					</tr>
				</table>
			</div>
			<!-- 페이지 -->
			<div class="button">
				<input type="button" value="글쓰기" onclick="location.href='/bbs/insert.do'">
			</div>
		</div>
	</div>
</body>
</html>