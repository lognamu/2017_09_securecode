<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/photo.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
	function download(filename){
		location.href = "${pageContext.request.contextPath }/download.do?dir=/upload/&filename="+filename;
	}
	
	function del(idx, filename){
		var userPwd = window.prompt("비밀번호를 입력하세요");
		$.ajax({
			url:"checkPwd.do",
			data:"idx="+idx+"&userPwd="+userPwd,
			method:"POST",
			success:function(data){
				console.log(data);
				if(data == 'correct'){
					//alert("비밀번호가 올바릅니다.");
					location.href="delete.do?idx="+idx+"&dir=/upload/&filename="+filename;
				}else{
					alert("비밀번호가 올바르지 않습니다");
				}
			}			
		});	
	}
</script>
</head>
<body>
	<div id="main_box">
		<h1>::PhotoGallery::</h1>
		<div align="center">
			<input id="button_add" type="button" value="사진올리기" onclick="location.href='insert_form.do'">
		</div>
		<div id="photo_box">
			<c:if test="${list.size() == 0 }">
				<div class="empty_msg" align="center">
					등록된 사진이 없습니다.
				</div>
			</c:if>
			<c:forEach var="vo" items="${list }">
				<div class="photo_type">
					<img src="../upload/${vo.filename }">
					<div class="title">${vo.title }</div>
					<div align="center">
						<input type="button" value="download" onclick="download('${vo.filename}')">
						<input type="button" value="delete" onclick="del('${vo.idx}','${vo.filename }')">
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>