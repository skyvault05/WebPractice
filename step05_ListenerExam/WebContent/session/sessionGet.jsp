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
<h1>session에 저장된 정보 확인하기</h1><p>

아이디 : <%=session.getAttribute("id") %><br>
주소 : <%=session.getAttribute("addr") %><br>
취미 : <%=session.getAttribute("hobbys") %><br>

<h3>application 정보 확인하기</h3>
메세지 : <%=application.getAttribute("message") %><p>
주소 : <%=application.getAttribute("addr") %><p>
</body>
</html>