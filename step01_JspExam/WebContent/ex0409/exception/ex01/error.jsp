<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
    <%//엣지같은 경우는 응답코드가 500이면 지꺼 페이지 내보냄(isErrorPage="true"로 해놓으면 응답코드가 기본으로 500임)
    	response.setStatus(200); //200은 정상응답
    %>
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
<h1>예외발생</h1>
exception : <%=exception %><p>
exception.getMessage() : <%=exception.getMessage() %><p>
exception.getClass() : <%=exception.getClass() %><p>
exception.getClass().getSimpleName() : <%=exception.getClass().getSimpleName() %><p>
</body>
</html>