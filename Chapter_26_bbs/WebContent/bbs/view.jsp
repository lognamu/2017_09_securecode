<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resource/css/style.css">   
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
	function insert(f){
		var name = f.name.value;
		var content = f.name.content;
		if(name == '' || content == ''){
			alert('이름과 내용을 모두 입력해 주세요');
			return;
		}
		f.submit();
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
			<table class="left">
				<tr>
					<th width="30%">제목</th>
					<td>
						${vo.title }
					</td>
				</tr>
				<tr>
					<th width="30%">글쓴이</th>
					<td>
						${vo.name }
					</td>
				</tr>
				<tr>
					<th colspan="2">내용</th>
				</tr>
				<tr>
					<td colspan="2">
						${vo.content }
					</td>
				</tr>
			</table>
		</div>
		<div class="footer">
			<div class="button">
				<input type="button" value="수정" onclick="location.href='/bbs/update.do?idx=${vo.idx}'">
				<input type="button" value="삭제" onclick="location.href='/bbs/delete.do?idx=${vo.idx}'">
				<input type="button" value="답글작성" onclick="location.href='/bbs/reply.do?idx=${vo.idx}'">
				<input type="button" value="목록" onclick="location.href='/bbs/list.do?page=${param.page}'">
			</div>
			<div class="comment"> 
				<table class="left">
					<c:if test="${empty vo.commentList}">
						<tr>
							<th colspan="2">
								댓글이 존재하지 않습니다.
							</th>
						</tr>
					</c:if>
					<c:forEach var="cvo" items="${vo.commentList }">
						<tr>
							<th width="30%">${cvo.name }</th>
							<td>
								${cvo.content }
							</td>
						</tr>
					</c:forEach>
				</table>
				<form action="/comment/insert.do" method="post">
					<input type="hidden" name="idx" value="${vo.idx }">
					<table class="left">
						<tr>
							<th width="30%">이름</th>
							<td>
								<input type="text" name="name">
							</td>
						</tr>
						<tr>
							<th width="30%">내용</th>
							<td>
								<input type="text" name="content">
							</td>
						</tr>
						<tr>
							<th colspan="2">
								<input type="button" value="댓글등록" onclick="insert(this.form)">
							</th>
						</tr>
					</table>
				</form>
				
			</div>
		</div>
	</div>
	
</body>
</html>