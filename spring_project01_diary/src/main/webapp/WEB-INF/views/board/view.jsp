<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
    uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>

<script>
$(function(){ 
	//목록 버튼
	$("#btnList").click(function(){
		location.href="${path}/board/list.do";
	});
	

	//삭제 버튼
	$("#btnDelete").click(function(){
		if(confirm("삭제하시겠습니까?")){
			document.form1.action="${path}/board/delete.do";
			document.form1.submit();
		}
	});
	

});

</script>

<style>
.fileDrop {
	width: 600px;
	height: 100px;
	border: 1px dotted gray;
	background-color: gray;
}
</style>

</head>
<body>
<h2>게시물 보기</h2>
<form id="form1" name="form1" method="post"">
	<div>제목 :  ${dto.title}
	</div>

	<div style="width:800px;">
		내용  : ${dto.content}
	<div style="width:700px; text-align:center;">
<!-- 수정,삭제에 필요한 글번호를 hidden 태그에 저장 -->	
		<input type="hidden" name="bno" value="${dto.bno}">
		
		<!-- 본인만 수정,삭제 버튼 표시 -->
		<sec:authorize access="isAuthenticated()">
        <sec:authentication property="principal.username" var="user_id" />
        </sec:authorize>
        <div id="user_id">
		<c:if test="${user_id == dto.id}">
		
		<td><a href="${path}/board/rewrite.do?bno=${dto.bno}">
			<button type="button" id="btnUpdate">수정</button>
		</a>

			<button type="button" id="btnDelete">삭제</button></td>
		</c:if>
		</div>
		<button type="button" id="btnList">목록</button>
	</div>
</div>
</form>
</body>
</html>
