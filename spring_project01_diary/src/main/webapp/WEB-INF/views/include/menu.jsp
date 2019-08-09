<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div style="text-align: right;">

<c:choose>
	<c:when test="${sessionScope.userid != null }">

		${sessionScope.name}의 기록<br>

	</c:when>
</c:choose>

-----------------<br>

<a href="${path}" align="left">Home</a> <br>

<a href="${path}/board/list.do"align="left">나의 기록</a>  <br>
<a href="${path}/board/list.do"align="left">자주 찾는 기록</a>  <br>
<br>
달력<br>
<br>
구글 차트 <br>
<br>
-----------------<br>

<c:if test="${sessionScope.admin_userid == 'admin' }">

	<a href="${path}/shop/product/write.do">개발자에게 문의하기</a> <br> 

</c:if>  

<c:choose>
	<c:when test="${sessionScope.userid != null }">

		<a href="${path}/member/logout.do">로그아웃</a><br>

	</c:when>
</c:choose>
</div>

<hr>








