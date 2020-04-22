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
<h1>ServletContext - application 변수</h1>
<h3>
	application.getContextPath() : <%=application.getContextPath() %><p>
	application.getRealPath() : <%=application.getRealPath("/") %><p>
	application.getMajorVersion() : <%=application.getMajorVersion() %><p>
	application.getMinorVersion() : <%=application.getMinorVersion() %><p>
	application.getServerInfo() : <%=application.getServerInfo() %><p>

<%
application.setAttribute("message", "졸지맙시다.");
application.setAttribute("addr", "판교.");

%>
<h3>application 정보 확인하기</h3>
메세지 : <%=application.getAttribute("message") %><p>
주소 : <%=application.getAttribute("addr") %><p>

<a href="../session/sessionGet.jsp">정보확인하러가자</a>
</h3>
</body>
</html>