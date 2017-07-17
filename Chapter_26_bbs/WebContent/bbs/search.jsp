<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script>
	$(document).ready(function(){
		var option = "${option}";
		var text = "${text}"
		if(option == "" || text == ""){
			return;
		}
		$("#search_option").children().each(function(index, item){
			if($(item).val() == option){
				$(item).attr('selected', true);
			}
		});
		$("#search_text").val(text);
	});
	
	function search(){
		var option = $("#search_option").val();
		var text = $("#search_text").val();
		if(option != "all" && text == ""){
			alert("검색어를 입력해 주세요");
		 	$("#search_text").focus();
		}
		location.href="/bbs/list.do?option="+option+"&text="+text;
	}
</script>
<hr>
<div class="search">
	<select id="search_option">
		<option value="all">전체</option>
		<option value="title">글제목</option>
		<option value="name">작성자</option>
		<option value="content">내용</option>
		<option value="title_name">글제목+작성자</option>
	</select> <input type="text" id="search_text"> <input type="button"
		value="검색" onclick="search()">
</div>
<hr>