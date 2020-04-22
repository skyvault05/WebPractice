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
<%//넘어오는 두 수를 받아서 계산
	int num1 =  Integer.parseInt(request.getParameter("num1"));
	int num2 =  Integer.parseInt(request.getParameter("num2"));
%>

<h1>두 수의 합 : <%=num1%>+<%=num2%>=<%=num1+num2%></h1>
</body>
</html>