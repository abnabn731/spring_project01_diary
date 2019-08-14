<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!--datapicker 사용을 위한 라이브러리  -->
<script type="text/javascript" src="jquery.js"></script>
<script type="text/javascript" src="jqueryUI.js"></script>    
<link rel="stylesheet" href="${path}/include/css/jqueryUI.css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
<script src="${path}/include/js/common.js"></script>
<script>
$(function(){ //자동으로 실행되는 코드

	$(function(){
		$("#btnWrite").click(function(){
			location.href="${path}/board/write.do";
		});
	});
	function list(page){
		location.href="${path}/board/list.do?curPage="+page;
	}

	$("#bookmark").click(function(){
		var bookmark = $("#bookmark").val(); 
		var bno="${dto.bno}"; 
		
		if (bookmark ==1) {
			bookmark=0
		} else if (bookmark==0) {
			bookmark=1
		}
		var param={ "bookmark": bookmark, "bno": bno};

		$.ajax({
			type: "post",
			url: "${path}/board/bookmarkUpdate.do",
			data: param,
			success: function(){
				alert("북마킹 테스트");
			}
		});
	});
});

</script>

</head>
<body style="background-color:#4f315e">
<div style ="width:200px; height:500px; float=left; background-color:#660066;" >
	<%@include file="../include/menu.jsp" %>
</div>

<div style="width:600px; height:700px; border:3px solid black; float:right"> 
<button type="button" id="btnWrite">글쓰기</button>

<table border="1"  width="400px">

	<c:forEach var="row" items="${map.list}">
		<tr>
			<td><fmt:formatDate value="${row.regdate}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
			<td><a href="${path}/board/view.do?bno=${row.bno}">${row.title}</a></td>
						
<%-- 			<c:when test="${row.bookmark}==1" >
	   			<td><button type="button" id="bookmark" value="${row.bookmark} }">[북마크 취소]</button></td>
	   		</c:when>
	   		<c:otherwise>
	   			<td><button type="button" id="bookmark" value="${row.bookmark} }">[  북마킹   ]</button></td>
			</c:otherwise> --%>
		</tr>
	</c:forEach>
</table>
</div>
</body>
</html>