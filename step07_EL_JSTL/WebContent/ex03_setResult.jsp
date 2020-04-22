<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<h1>결과 확인하자</h1>
아이디 : ${id} / <c:out value="${id}"/> / ${sessionScope.id} <p> 
메세지 : ${message} / <c:out value="${message}"/> / ${applicationScope.message}<p>
나이 : ${age} / <c:out value="${age}"/><p>

<h1>삭제함</h1>
<c:remove var="message"/>

아이디 : ${id} / <c:out value="${id}"/> / ${sessionScope.id} <p> 
메세지 : ${message} / <c:out value="${message}"/> / ${applicationScope.message}<p>
나이 : ${age} / <c:out value="${age}"/><p>
</body>
</html>