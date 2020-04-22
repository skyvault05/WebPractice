<%@page import="java.util.Date"%>
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
	Cookie[] cookies = request.getCookies();
	boolean flag = true;
	for(Cookie co : cookies){
		if(co.getName().equals("lastVisit")){
			long lastTime = Long.parseLong(co.getValue());
			out.println(new Date(lastTime));
			flag=false;
			break;
		}
	}
	
	String curr = System.currentTimeMillis()+"";
	Cookie currVisit = new Cookie("lastVisit", curr);
	currVisit.setPath("/");
	currVisit.setMaxAge(60*60);
	response.addCookie(currVisit);
	
	if(flag){
		%><h2>당신은 처음 방문하셨습니다.</h2><%
	}
%>
</body>
</html>