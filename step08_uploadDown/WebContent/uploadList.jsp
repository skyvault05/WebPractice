<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
a{
	color:black;
	text-decoration: none;
}
a:hover{
	font-size:20px;
}
</style>
<script>

</script>
</head>
<body>

<c:forEach items="${files}" var="file" varStatus="status">
	<a href="<%=application.getContextPath()%>/downLoad?fileName=${file.name}">${status.count}. ${file.name}</a><br>
</c:forEach>
</body>
</html>