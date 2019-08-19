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



<form action="${path}/chart/insert.do" method="post">

<div>
<table>
	<tr>
		<td> question1 </td>
		<td> <input type="radio" name="q1" value=5 > 매우 그렇다 </td>
		<td> <input type="radio" name="q1" value=4 > 그렇다 </td>
		<td> <input type="radio" name="q1" value=3 > 보통이다 </td>
		<td> <input type="radio" name="q1" value=2 > 아니다</td>
		<td> <input type="radio" name="q1" value=1 > 매우 아니다 </td>
	</tr>
	<tr>
		<td> question2 </td>
		<td> <input type="radio" name="q2" value=5 > 매우 그렇다 </td>
		<td> <input type="radio" name="q2" value=5 > 그렇다 </td>
		<td> <input type="radio" name="q2" value=3 > 보통이다 </td>
		<td> <input type="radio" name="q2" value=2 > 아니다</td>
		<td> <input type="radio" name="q2" value=1 > 매우 아니다 </td>
	</tr>
	<tr>
		<td> question3 </td>
		<td> <input type="radio" name="q3" value=5 > 매우 그렇다 </td>
		<td> <input type="radio" name="q3" value=4 > 그렇다 </td>
		<td> <input type="radio" name="q3" value=3 > 보통이다 </td>
		<td> <input type="radio" name="q3" value=2 > 아니다</td>
		<td> <input type="radio" name="q3" value=1 > 매우 아니다 </td>
	</tr>
	<tr>
		<td> question4 </td>
		<td> <input type="radio" name="q4" value=5 > 매우 그렇다 </td>
		<td> <input type="radio" name="q4" value=4 > 그렇다 </td>
		<td> <input type="radio" name="q4" value=3 > 보통이다 </td>
		<td> <input type="radio" name="q4" value=2 > 아니다</td>
		<td> <input type="radio" name="q4" value=1 > 매우 아니다 </td>
	</tr>
	<tr>
		<td> question5 </td>
		<td> <input type="radio" name="q5" value=5 > 매우 그렇다 </td>
		<td> <input type="radio" name="q5" value=4 > 그렇다 </td>
		<td> <input type="radio" name="q5" value=3 > 보통이다 </td>
		<td> <input type="radio" name="q5" value=2 > 아니다</td>
		<td> <input type="radio" name="q5" value=1 > 매우 아니다 </td>
	</tr>
<tr>

<td> <input type="submit" value="기록하기"> </td>

</tr>
</table>
</div>
</form>
</body>
</html>