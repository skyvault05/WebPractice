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
<h1>EL - 표현언어 TEST</h1>
<h3>
\${5} = ${5} <br>
\${5+3} = ${5+3} <br>
\${5-2} = ${5-2} <br>
\${5 / 2} = ${5 / 2} <br>
\${5 gt 3} = ${5 gt 3} <br>
\${5 gt 3 and 3 eq 3} = ${5 gt 3 and 3 eq 3} <br>
\${5 > 3 ? "맞다" : "틀리다"} = ${5 > 3 ? "맞다" : "틀리다"} <br>
<hr>
<!-- 쿼리 스트링으로 request 보내기 -->
${param.age > 18 ? "성인" : "미성년자"} <br>
${param.id == null ? "Guest" : param.id} 님(==null) <br>
${empty param.id ? "Guest" : param.id} 님(empty) <br>
${not empty param.id ? param.id : "Guest" } 님(not empty) <br>

${not empty param.id ? param.id+=" 학생" : "Guest"+=" 님"} <br>
${not empty param.id ? param.id.concat(" 학생") : "Guest".concat(" 님")} <br>

Scope에 저장된 데이터 EL로 출력하기<p>
<%
	//scope영역에 데이터가 저장돼있어야함.
	request.setAttribute("addr", "서울");

	session.setAttribute("id", "jang");
	session.setAttribute("message", "졸립다...");
	
	application.setAttribute("message", "우리모두 선거합시다");
	application.setAttribute("hobby", "먹고 놀기");
%>
requsetScope 영역<br>
주소 : ${requestScope.addr} / ${addr} <br>
<br>
sessionScope 영역<br>
아이디 : ${sessionScope.id} / ${id}<br>
메세지 : ${sessionScope.message} / ${message}<br>
<br>
applicationScope 영역<br>
메세지 : ${applicationScope.message} / ${message}<br>
취미 : ${applicationScope.hobby } / ${hobby }<br>
<br>

Product객체안에 있는 데이터 표현언어로 출력하기 <p>

<jsp:useBean id="p" class="ex0413.el.Product" scope="page"></jsp:useBean>

코드 : <%=p.getCode() %> / ${p.code }<br>
이름 : <%=p.getName() %> / ${p.name }<br>
가격 : <%=p.getPrice() %> / ${p.price }<br>
수량 : <%=p.getQty() %> / ${p.qty }<br>
총금액 : <%=p.getPrice() * p.getQty() %> / ${p.price * p.qty }<br>

</h3>
</body>
</html>