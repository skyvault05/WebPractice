<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   String id = request.getParameter("id");
   if(id.equals("id1")){
	   %>{"status":-1, "msg":"이미 사용중인 ID입니다."}<%
   }else{
	   %>{"status":1, "msg":"사용 가능한 ID입니다."}<%
   }
%>