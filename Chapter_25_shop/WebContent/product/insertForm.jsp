<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/resource/css/style.css">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
	function checkdata(f){
		var category = f.category.value;
		var model = f.model.value;
		var manufacturer = f.manufacturer.value;
		console.log("제조사", manufacturer);
		var price_ori = f.price_ori.value;
		var price_sale = f.price_sale.value;
		var content = f.content.value;
		var image_s = f.image_s.value;
		var image_l = f.image_l.value;
		
		if(category == "" || model == "" || manufacturer  == "" ||
		   price_ori  == "" || price_sale  == "" || content  == "" ||
		   image_s  == "" || image_l  == ""){
			alert("모두 입력하세요");
			return;
		}
		
		f.submit();
	}
</script>
</head>
<body>
	<jsp:include page="/product/menu.jsp"/>
	<form name="f" method="post" action="/product/insert.do" enctype="multipart/form-data">
		<table class="center">
			<tr>
				<th>카테고리</th>
				<td>
					<select name="category">
						<option value="">::선택::</option>
						<option value="com001">컴퓨터</option>
						<option value="ele002">가전제품</option>
						<option value="sp003">스포츠</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>모델명</th>
				<td>
					<input name="model">
				</td>
			</tr>
			<tr>
				<th>제조사</th>
				<td>
					<input name="manufacturer">
				</td>
			</tr>
			<tr>
				<th>원가격</th>
				<td>
					<input name="price_ori">
				</td>
			</tr>
			<tr>
				<th>할인가격</th>
				<td>
					<input name="price_sale">
				</td>
			</tr>
			<tr>
				<th>제품설명</th>
				<td>
					<textarea name="content" rows="5" cols="50"></textarea>
				</td>
			</tr>
			<tr>
				<th>제품사진(작은사진)</th>
				<td>
					<input type="file" name="image_s">
				</td>
			</tr>
			<tr>
				<th>제품사진(큰사진)</th>
				<td>
					<input type="file" name="image_l">
				</td>
			</tr>
			<tr>
				<th colspan="2">
					<input type="button" value="등록" onclick="checkdata(this.form)">
					<input type="reset" value="다시입력">
				</th>
			</tr>
		</table>
	</form>
</body>
</html>