<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%
    	response.setHeader("Cache-Control", "no-store");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	$(function(){
		$('#logout').click(function(){
			if(confirm('로그아웃 하시겠습니까?')){
				location.href = "logout.jsp";
			}
			
		});		
	});
</script>
</head>
<body>
<p>
<%-- <%
if(session.getAttribute("name")!=null){
	%>접속시간 : <%out.print(session.getAttribute("creationTime"));
	out.print("<br>");
	out.print(session.getAttribute("name"));%>님 안녕하세요!<%
}else{
	out.println("<script>");
	out.println("alert('먼저 로그인 해 주세요.')");
	out.println("location.href = 'LoginForm.html'");
	out.println("</script>");
}
%> --%>

<c:choose>
	<c:when test="${not empty sessionScope.name}">
		접속시간 : ${sessionScope.creationTime} <br>
		${sessionScope.name}님 안녕하세요!
	</c:when>
	<c:otherwise>
		<script>
			alert("먼저 로그인 해 주세요.");
			location.href = 'LoginForm.html';
		</script>
	</c:otherwise>
</c:choose>

</p>
<img src="HDR_0002.JPG" alt="picture" width="500px" height="600px"><br>
<button id="logout" type="submit">로그아웃</button>
</body>
</html>