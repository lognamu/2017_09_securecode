<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resource/css/style.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
	function addCart(idx){
		$.ajax({
			url:"/cart/insert.do",
			data:{"p_idx":idx, "u_idx":1},
			success:function(data){
				console.log(data);
				if(data == "yes"){
					alert("장바구니에 담았습니다");
				}else{
					alert("이미 동일한 제품이 장바구니에 존재합니다.");
				}
				
				if(confirm("장바구니로 이동하시겠습니까?")){
					location.href="/cart/list.do";
				}
			}
		});
	}
</script>
</head>
<body>
	<jsp:include page="/product/menu.jsp"/>
	<table class="center">
		<tr>
			<th width="40%">카테고리</th>
			<td width="60%">${vo.category}</td>
		</tr>
		<tr>
			<th width="40%">모델명</th>
			<td width="60%">${vo.model}</td>
		</tr>
		<tr>
			<th width="40%">제조사</th>
			<td width="60%">${vo.manufacturer }</td>
		</tr>
		<tr>
			<th width="40%">제품가격</th>
			<td width="60%">
				<fmt:formatNumber type="number" value="${vo.price_ori }"/>원
				(할인적용가:<fmt:formatNumber type="number" value="${vo.price_sale }"/>원)
			</td>
		</tr>
		<tr>
			<th colspan="2">제품설명</th>
		</tr>
		<tr>
			<td colspan="2">${vo.content }</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="장바구니 담기" onclick="addCart('${vo.idx}')"/>
				<input type="button" value="장바구니 보기" onclick="location.href='/cart/list.do'"/>
			</td>
		</tr>
	</table>
</body>
</html>