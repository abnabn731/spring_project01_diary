<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>

</head>
<body>
<%@ include file="../include/menu.jsp" %>
<h2>글쓰기</h2>
<form method="post" action="${path}/board/insert.do">
	<div>제목 <input name="title" id="title" size="80"
					placeholder="제목">
	</div>
	<div style="width:800px;">
		내용 <textarea id="content" name="content"
rows="3" cols="80" placeholder="내용"></textarea>

<div>
	<input type="submit" value="작성완료">
</div>
</div>
</form>

</body>
</html>