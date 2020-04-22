<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

</style>
<script>

</script>
</head>
<body>
<%
	//post방식으로 전송되는 데이터 한글 인코딩 처리
	request.setCharacterEncoding("utf-8");
%>
<jsp:forward page='<%= request.getParameter("blood")+".jsp" %>'>
	<jsp:param value='<%= request.getParameter("name") %>' name="name"/>
</jsp:forward>
</body>
</html>