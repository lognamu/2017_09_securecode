<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resource/css/style.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
	function update(){
		var f = document.getElementById('f');
		var title = f.title.value;
		var name = f.name.value;
		var content = f.content.value;
		if(title == '' || name == '' || content == ''){
			alert('모두 입력해주세요');
			return;
		}
		f.submit();
	}
</script>
</head>
<body>
	<div class="main">
		<div class="header">
			<h3>| 게시물 등록 |</h3>
			<jsp:include page="/bbs/search.jsp"/>
		</div>
		<div class="body">
			<form id="f" action="/bbs/update.do" method="post">
				<input type="hidden" name="idx" value="${vo.idx }">
				<table class="left">
					<tr>
						<th width="30%">제목</th>
						<td>
							<input type="text" name="title" value="${vo.title }">
						</td>
					</tr>
					<tr>
						<th width="30%">글쓴이</th>
						<td>
							<input type="text" name="name" value="${vo.name }">
						</td>
					</tr>
					<tr>
						<th colspan="2">내용</th>
					</tr>
					<tr>
						<td colspan="2">
							<textarea name="content" rows="5" cols="20">${vo.content }</textarea>
						</td>
					</tr>
				</table>
			</form>
		</div>
		<div class="footer">
			<div class="button">
				<input type="button" value="수정" onclick="update()">
				<input type="button" value="취소" onclick="history.back()">
			</div>
		</div>
	</div>
	
</body>
</html>