<%@page import="com.my.vo.Product"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Map<Product, Integer>cart = (Map)session.getAttribute("cart");
if(cart != null){
   boolean isFirst=true;//처음
%>{"status": 1,
   "products":[
<% for(Product p: cart.keySet()){%>
<%    if(!isFirst){//처음아닐때만 콤마찍기
%>,      
<%        
      }%>
     {<%=p%>, "quantity": <%=cart.get(p) %>} 
       
   
<%    isFirst = false;
    }//end for
%>]}   
<%}else{%>   
{"status":-1, "msg":"장바구니가 비었습니다"}   
<%}
%>