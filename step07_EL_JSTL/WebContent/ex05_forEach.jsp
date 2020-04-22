<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table{
	width:600px;
	text-align:center;
	padding:3px;
	border:1px solid;
	border-radius:3px;
	border-collapse: collapse;
}
th{
	border-bottom:1px solid;
}
td{
	border-bottom:1px solid;

}
</style>
<script>

</script>
</head>
<body>
<h1> &lt;c:forEach> TEST</h1>

<c:forEach begin="1" end="10" var="i">${i} </c:forEach>

<hr>

<%
	String[] hobbys = {"등산", "수영", "낚시", "골프"};
	
%>



<c:forEach items="<%=hobbys%>" var="h" varStatus="state">
	${h} / ${state.count} / ${state.index}<br>
</c:forEach>

<hr>

<jsp:useBean id="bean" class="ex0413.jstl.ForEachBean"/>
<!-- names는 select박스로 출력 -->
<select>
	<option style="display:none;">--이름선택--</option>
	<c:forEach items="${bean.names}" var="name">
		<option value="${name}">${name}</option>
	</c:forEach>	
</select>
<!-- menus는 checkbox로 출력 -->
<hr>
<fieldset>
	<legend>메뉴 선택</legend>
	<c:forEach items="${bean.menus}" var="menu">
		<input type="checkbox" name="menu" value="${menu}">${menu} 
	</c:forEach>	
</fieldset>
<hr>
<!-- memberList는 테이블로 출력 -->
<table>
	<thead>
		<tr>
			<th>no</th>
			<th>id</th>
			<th>age</th>
			<th>addr</th>
			<th>phone</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${bean.memberList}" var="member" varStatus="stat">
		<tr>
			<td>${stat.count}</td>
			<td>${member.id}</td>
			<td>${member.age}</td>
			<td>${member.addr}</td>
			<td>${member.phone}</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
<hr>
<!-- map은 radio로 출력 -->
<fieldset>
	<legend>국가 선택</legend>
	<c:forEach items="${bean.map}" var="m">
		<input type="radio" name="nation" value="${m.key}">${m.value}(${m.key}) 	
	</c:forEach>
	
</fieldset>
<hr>

가격 : 398492452134원<br>
가격 : <fmt:formatNumber value="398492452134"/>원
</body>
</html>