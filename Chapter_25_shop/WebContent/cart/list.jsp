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
	function del(idx){
		if(confirm("정말로 삭제하시겠습니까?")){
			location.href="/cart/delete.do?idx=" + idx;
		}
	}
	
	function update(f){
		var count = f.count.value;
		var numchk = /^[0-9]+$/;
		var isNumber = numchk.test(count);
		console.log(isNumber);
		if(!isNumber || count < 1){
			alert('1이상의 숫자만 입력해주세요');
			f.count.value = f.count_ori.value;
			return;
		}
		if(confirm("정말로 수정하시겠습니까?")){
			f.submit();
		}
	}
</script>
</head>
<body>
	<table class="center">
		<tr>
			<td colspan="5">::장바구니::</td>
		</tr>
		<tr class="header">
			<th>모델명</th>
			<th>단가</th>
			<th>수량</th>
			<th>금액</th>
			<th>삭제</th>
		</tr>
		<c:if test="${list == null || list.size() == 0 }">
			<tr>
				<td colspan="5" class="cent bold">
					장바구니가 비었습니다.
				</td>
			</tr>
		</c:if>
		<c:forEach var="vo" items="${list }">
			<tr class="cent">
				<td>${vo.pvo.model }</td>
				<td>
					단가:<fmt:formatNumber value="${vo.pvo.price_ori }"/><br>
					<span>
						할인적용가:<fmt:formatNumber value="${vo.pvo.price_sale }"/><br>
					</span>
				</td>
				<td>
					<form action="/cart/update.do" method="post">
						<input type="hidden" name="idx" value="${vo.idx }">
						<input type="hidden" name="count_ori" value="${vo.count }">
						<input type="text" name="count" value="${vo.count }">
						<input type="button" value="수정" onclick="update(this.form)">
					</form>
				</td>
				<td>
					<fmt:formatNumber value="${vo.count * vo.pvo.price_sale }" />
				</td>
				<td>
					<input type="button" value="삭제" onclick="del('${vo.idx}')"> 
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="4" class="right">
				총 결재액 : 
			</td>
			<td>
				<fmt:formatNumber value="${totalAmount }"/>
			</td>
		</tr>
	</table>
</body>
</html>