<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resource/css/style.css"> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
	<jsp:include page="/product/menu.jsp"/>
	<div class="right">
		<input type="button" value="상품등록" onclick="location.href='/product/insertForm.do'">
	</div>
	<div class="center">
		<table class="center">
			<tr>
				<th width="10%">제품번호</th>
				<th width="10%">이미지</th>
				<th width="35%">제품모델</th>
				<th width="20%">제품가격</th>
				<th width="25%">비고</th>
			</tr>       
			<!-- 제품이 없는 경우 -->
			<c:if test="${list.size() == 0 }">
				<tr>
					<td colspan="5" align="center">제품이 존재하지 않습니다.</td>
				</tr>
			</c:if>
			<c:forEach var="vo" items="${list }">
				<tr>
					<td>제품정보</td>
					<td>
						<img src="/images/${vo.image_s }" width="100" height="90">
					</td>
					<td>
						<a href="/product/view.do?idx=${vo.idx }">${vo.model }</a>
					</td>
					<td>
						할인가:<f:formatNumber value="${vo.price_sale }"/>원<br>
						<span>할인율(${vo.sale_rate }%)</span>
					</td>
					<td>
						단가:<f:formatNumber value="${vo.price_ori }"/>원
					</td>
				</tr>
			</c:forEach>
	    </table>
	</div>
</body>
</html>