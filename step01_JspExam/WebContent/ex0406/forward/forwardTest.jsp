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
<%request.setCharacterEncoding("utf-8"); %>
<h1>forward 액션 태그</h1>
<%
	int sum=0;
	for(int i=0; i<=10; i++){
		//out.println(i+"<br>");
		sum += i;
	}

%>

<jsp:forward page="forwardResult.jsp">
	<jsp:param value="<%= sum %>" name="total"/>
	<jsp:param value="희정" name="name"/>
</jsp:forward>
</body>
</html>