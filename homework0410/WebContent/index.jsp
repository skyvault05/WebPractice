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
table{
	width:80%;
	margin:auto;
}
iframe{
	width:100%;
	border:none;
	height:500px;
	
}
#aside{
	width:32%;
}

</style>
<script>

</script>
</head>
<body>
	<table>
		<tr id="nav">
			<td colspan="2">
				<jsp:include page="top.jsp" />			
			</td>
		</tr>
		<tr id="section">
			<td id="aside">
				<iframe src="left.jsp"></iframe>
			</td>
			<td id="article">
				<iframe src="center.jsp"></iframe>
			</td>
		</tr>
		<tr id='footer'>
			<td colspan="2">
				<jsp:include page="footer.jsp"></jsp:include>
			</td>
		</tr>		
	</table>
</body>
</html>