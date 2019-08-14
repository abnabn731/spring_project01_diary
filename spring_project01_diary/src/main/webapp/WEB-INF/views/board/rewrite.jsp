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
<%@ include file="../include/menu.jsp" %>
<h2>게시물 보기</h2>
<form method="post" action="${path}/board/update.do">
	<div>제목 <input name="title" id="title" size="80"
					value="${dto.title}"
					placeholder="제목을 입력하세요">
	</div>

	<div style="width:800px;">
		내용 <textarea id="content" name="content"
rows="3" cols="80" 
placeholder="내용을 입력하세요">${dto.content}</textarea>


	<div style="width:700px; text-align:center;">
	
		<!-- 글수정에 필요한 bno 넘김 -->	
		<input type="hidden" name="bno" value="${dto.bno}">
		
		<div>
			<input type="submit" value="작성완료">
		</div>
		

	</div>
</form>
</body>
</html>
