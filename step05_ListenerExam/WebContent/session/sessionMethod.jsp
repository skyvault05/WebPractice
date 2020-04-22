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
<h1>HttpSession - session 변수</h1>
<%
//set session maxInterval
session.setMaxInactiveInterval(30);

%>
<h3>
	session.getId() : <%=session.getId() %><p>
	session.getMaxInactiveInterval() : <%=session.getMaxInactiveInterval() %><p>
	session.getCreationTime() : <%=session.getCreationTime() %><p>
	session.getLastAccessedTime() : <%=session.getLastAccessedTime() %><p>
	session.isNew() : <%=session.isNew() %><p>
</h3>

<hr>
	session Set Attribute
<%
	session.setAttribute("id", "jang");
	session.setAttribute("addr", "판교");
	session.setAttribute("hobbys", new String[]{"등산", "수영", "낚시"});
%>
<hr>
session에 저장된 정보 확인하기<p>
아이디 : <%=session.getAttribute("id") %><br>
주소 : <%=session.getAttribute("addr") %><br>
취미 : <%=session.getAttribute("hobbys") %><br>

<a href="sessionGet.jsp">session정보 화인하러 가자.</a>
</body>
</html>