<%@page import="java.util.concurrent.atomic.AtomicInteger"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>

<style>

form{
	margin-top:10px;
}
</style>

<script>
$(function(){
	$('body').on("click", "#logout", function(){
		location.href="<%=application.getContextPath()%>/logout";
	});
	
	if(<%=session.getAttribute("name")==null%>){
		let str = '<form action="<%=application.getContextPath()%>/login">';
		str += '<div class="form-group">';
		str += '<label for="exampleInputEmail1">Email address</label>';
		str += '<input type="id" class="form-control" name="id" id="id" aria-describedby="emailHelp">';
		str += '</div>';
		str += '<label for="exampleInputPassword1">Password</label>';
		str += '<input type="password" class="form-control" name="pwd" id="pwd">';
		str += '</div>';
		str += '<button type="submit" class="btn btn-primary">로그인</button>';
		str += '</form>';
		$('body').html(str);
	}else{
		<%
		Object obj = application.getAttribute("userCounter");
		AtomicInteger counter = (AtomicInteger) obj;
		int counterInt = counter.get();
		%>
		let str = '<%=session.getAttribute("name")%>님 로그인중..<br>';
		str += '접속 시간:<%=session.getAttribute("creationTime")%><br>';
		str += '<button id="logout">로그아웃</button><br>';

		str += '현재 접속자수 : <%=counterInt%>';
		$('body').html(str);
	}
	
});
</script>
</head>
<body>
	
	  
	    
	    
	  
	  
	    
	    
	  
	  
			
	
	
	<%-- 
	
			

 --%>

</body>
</html>