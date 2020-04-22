<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>

</script>
</head>
<body>
<h2>ServletContextListener Test</h2>

<fieldset>
	<legend>나라선택</legend>
	<%//나라정보가져오기
		Object obj = application.getAttribute("nation");
		Map<String, String> nations = (Map) obj;
		for(String n : nations.keySet()){
			String value = nations.get(n);
			%>
			<input type="radio" name="nation" value="<%=n%>"><%=value %>
			<%
		}
	%>
</fieldset>

<hr>
applicatoin.getContextPath() : <%=application.getContextPath() %><br>
applicatoin.getAttribute("path") : <%=application.getAttribute("path") %><br>

EL언어로 : ${application.path} <br>
EL언어로 : ${path}  (Attribute에 있는것만 가능)<br>

</body>
</html>