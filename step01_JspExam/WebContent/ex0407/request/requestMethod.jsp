<%@page import="java.util.Enumeration"%>
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
<h1> request Headers</h1>
<%
	Enumeration<String> e = request.getHeaderNames();
	while(e.hasMoreElements()){
		String name = e.nextElement();
		String value = request.getHeader(name);
		out.print(name+" : "+value+"<br>");
	}
%>
</body>
</html>