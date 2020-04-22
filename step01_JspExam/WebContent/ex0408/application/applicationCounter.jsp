<%@page import="java.util.concurrent.atomic.AtomicInteger"%>
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
<%-- <%
	if(application.getAttribute("counter")==null){
		application.setAttribute("counter", (Integer)1);
	}else{
		int counter = (int) application.getAttribute("counter");
		if(session.isNew()){
			application.setAttribute("counter", (Integer) counter+1);
		}
		
	}
	
%> --%>

<%
	 
	if(application.getAttribute("counter")==null){
		application.setAttribute("counter", new AtomicInteger());
		AtomicInteger it = (AtomicInteger) application.getAttribute("counter");
		it.getAndIncrement();
	}else{
		if(session.isNew()){
			AtomicInteger it = (AtomicInteger) application.getAttribute("counter");
			it.getAndIncrement();
		}
		
	}	

%>
<h3>총 방문자수 : <%=application.getAttribute("counter") %></h3>
</body>
</html>