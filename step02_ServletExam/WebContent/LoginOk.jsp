<%@page import="java.util.List"%>
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
<h1><%=request.getParameter("userName") %>님 로그인 성공!!</h1>
<%
	Object obj = request.getAttribute("list");
	if(obj!=null){
		List<String> hobbys = (List<String>)obj;
		
		for(String h : hobbys){
			%>
			<input type="checkbox" name="hobby" value="<%=h%>"><%=h%>			
			<%
		}
		%>
		<fieldset>
		
		
		</fieldset>
		<%
	}



%>
</body>
</html>