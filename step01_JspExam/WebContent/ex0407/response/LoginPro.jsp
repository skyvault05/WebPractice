<%@page import="java.net.URLEncoder"%>
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
<%	//response.setCharacterEncoding("utf-8");
	//request.setCharacterEncoding("utf-8");
	String dbId="jang", dbPwd="1234";
	String name = request.getParameter("userName");
	if(request.getParameter("userId").equals(dbId) && request.getParameter("userPwd").equals(dbPwd)){
		
		//redirect방식으로 보냄 , url은 ASCII코드만 들어가야 해서 인코딩 해줘야함
		//response.sendRedirect("LoginOK.jsp"+"?userName="+URLEncoder.encode(name, "utf-8"));
		
		//forward방식으로 보냄 -메소드이용 태그아님
		RequestDispatcher rd = request.getRequestDispatcher("LoginOK.jsp");
		rd.forward(request, response);
	} else{//메세지 출력
		//톰캣에선 동적 코드부터 실행시켜 반환하기 때문에 response.sendRedirect("LoginForm.html");이 먼저 실행됨
		//그래서 스크립트가 윗줄에서 있어도 실행은 동적코드가 먼저 돼서 alert이 뜨기 전에 리다이렉트됨 그래서 history나 location을 마지막에 실행되는 스크립트 쪽에 넣어서 처리함.
		out.println("<script>");
		out.println("alert('"+name+"님 정보를 확인해 주세요..')");
		out.println("history.back()");
		out.println("</script>");
		
		%>
			<%-- <script type="text/javascript">
				alert("<%=name%>님 정보를 확인해 주세요.");
				//location.href= "LoginForm.html";
				history.back();
			</script> --%>
		<%
		//response.sendRedirect("LoginForm.html");
	}

%>
</body>
</html>