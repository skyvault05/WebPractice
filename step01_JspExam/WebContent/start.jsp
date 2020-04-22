<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>이제 쉬어요~~^^</h1>
<%
	//자바코드 작성
	String name="장희정이뿌다...";
	System.out.println("넌 어디에 출력되니?");
	String menu="짜장 아니 짬뽕";
%>

<h3>오늘 점심 뭐먹지?</h3>

<h3>오늘 점심은 : <%=menu %>></h3>

메소드 호출 : <%=test(20) %><br>


<%! 
	String name;
	int age;
	
	public String test(int age){
		System.out.println();
		return age+"살 입니다.";
	}

%>

<%
	Date today = new Date();

%>
<%=today.toLocaleString() %>
</body>
</html>