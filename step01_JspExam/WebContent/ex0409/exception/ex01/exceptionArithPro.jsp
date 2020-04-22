<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
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
<%//숫자 받아서 나누기
	int num1 =  Integer.parseInt(request.getParameter("num1"));
	int result = 100/num1;
%>

<h1>나눈 값 : 100/<%=num1%>=<%=result%></h1>
</body>
</html>