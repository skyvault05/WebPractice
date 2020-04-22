<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.OutputStreamWriter"%>
<%@page import="java.io.File"%>
<%@page import="java.io.FileWriter"%>
<%@page import="java.io.Writer"%>
<%@page import="java.io.BufferedWriter"%>
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
<%
	request.setCharacterEncoding("utf-8");
	
	String txtRealPath = application.getRealPath("/ex0408/ex02/txt/");
	out.println("<h2>"+txtRealPath+"</h2>");
	File folder = new File(txtRealPath);
	if(!folder.exists()){
		folder.mkdirs();
	}
	String fileName = txtRealPath+request.getParameter("name")+"_"+System.currentTimeMillis()+".txt";

	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "utf-8"));
	
	bw.write("작성 : "+request.getParameter("name"));
	bw.newLine();
	bw.write("제목 : "+request.getParameter("subject"));
	bw.newLine();
	bw.write("내용 : "+request.getParameter("content"));
	bw.newLine();
	bw.flush();
	bw.close();
	
	File path = new File(application.getRealPath("/ex0408/ex02/txt/"));
	File[] fileList = path.listFiles();
	out.print("파일목록 : ");
	for(File f : fileList){
		out.print("<p>"+f.getName()+"</p>");
	}
	
%>
</body>
</html>