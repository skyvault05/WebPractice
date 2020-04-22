<%@page import="homework0410.dto.BoardDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style>
	table{
		width:90%;
		margin: auto;
	}
	tr{
		height: 23px;
	}
	th{
		border-bottom: 1px solid;
		text-align: center;
	}
	td{
	}
</style>
<script>
	$(function(){
		if(<%=session.getAttribute("name")!=null%>){
			let str = `
				<form action='<%=application.getContextPath()%>/boardListener' style='text-align:center;'>
					내용 : <input type='text' name='content'>
					<input type='submit'>
				</form>
			`;
			$('body').append(str);
		}
	});
</script>
</head>
<body>
	<table>
		<tr>
			<th>닉네임</th>
			<th>내용</th>
			<th>작성시간</th>
		</tr>
			<%
			Object obj = application.getAttribute("boardList");
			List<BoardDTO> list = (List)obj;
			for(BoardDTO b : list){
				String str = "<tr>";
				str += "<td>"+b.getName()+"</td>";
				str += "<td>"+b.getContent()+"</td>";
				str += "<td>"+b.getDate()+"</td>";
				str += "</tr>";
				out.println(str);
			}
			%>
	</table>
</body>
</html>