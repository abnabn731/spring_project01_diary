<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<script>
$(function() {
    $( "#testDatepicker" ).datepicker({
    	
        changeMonth: true, 
        changeYear: true,
        nextText: '다음 달',
        prevText: '이전 달' 
        
    });
});


</script>

<div style="text-align: left;">

<c:choose>
	<c:when test="${sessionScope.userid != null }">

		${sessionScope.name}의 기록<br>

	</c:when>
</c:choose>


<a href="${path}" >Home</a> <br>

<a href="${path}/board/list.do" >나의 기록</a>  <br>
<a href="${path}/board/list.do" >자주 찾는 기록</a>  <br>
<br>

<!-- 달력 -->
<%@ include file="../include/calendar.jsp" %>


<br>

<!-- 구글 차트 (안녕지수 차트)-->
나의 안녕 지수 <br>

<%@ include file="../include/chart.jsp" %><br>
<a href="${path}/chart/quest.do">오늘의 안녕지수 기록하기</a>

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








