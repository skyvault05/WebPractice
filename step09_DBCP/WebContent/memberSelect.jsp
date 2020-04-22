<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
  table{width:100%; border:5px dobule red}
  th,td{padding:5px; border: 1px solid pink ; text-align: center }
  a{text-decoration: none}
 </style>

</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
$(function(){
	//검색버튼을 클릭했을 때 
	$('input[value=검색]').click(function(){
		if($('[name=keyField]').val()=="0"){
			alert('검색 필드를 선택 해 주세요');
			$('[name=keyField]').focus();
			return;
		}
		
		if($('[name=keyWord]').val()==""){
			alert('내용을 입력해 주세요');
			$('[name=keyWord]').focus();
			return;
		}
		
		//전송하기
		$('form[name=search]').submit();
	});//검색버튼 클릭 끝
	
	$("button[type='button']").click(function(){
		if(confirm("삭제하실래요?")){
			let id = $(this).parent().parent().find("td:first").next().text();
			//lecation.href="delete?id="+id; //	보안상 문제때문에 get방식은 x
			
			$('input[name=id]').val(id);
			$('form[name=del]').submit();
		}
	});
});
</script>
<body>

<center>
 <h1>[ 회원 정보 LIST ]</h1>
<table cellspacing="0">
  <tr>
    <th colspan="9" style="text-align:right">
      <a href="memberForm.html">[ 회원가입 ]</a>&nbsp;&nbsp;&nbsp;
      <a href="index.html">[ 새로고침 ]</a>&nbsp;&nbsp;&nbsp;
    </th>
  </tr>
  <tr bgColor="pink">
    <th>번호</th>
    <th>아이디</th>
    <th>비밀번호</th>
    <th>이름</th>
    <th>나이</th>
    <th>주소</th>
    <th>연락처</th>
    <th>가입일</th>
    <th>삭제</th>
  </tr>
  <c:forEach items="${list}" var="member" varStatus="status">
  	<tr>
  		<td>${status.count}</td>
  		<td><a href="read?id=${member.id}">${member.id}</a></td>
  		<td>${member.pwd}</td>
  		<td>${member.name}</td>
  		<td>${member.age}</td>
  		<td>${member.addr}</td>
  		<td>${member.phone}</td>
  		<td>${member.joinDate}</td>
  		<td><button type="button">삭제</button></td>
  	</tr>
  </c:forEach>
       
 
</table>
<p>

<form name="search" action="search" method="post">
 <select name="keyField">
   <option value="0" style="display:none;">--선택--</option>
   <option value="id">아이디</option>
   <option value="name">이름</option>
   <option value="addr">주소</option>
 </select>
 
<input type="text" name="keyWord"/>
<input type="button" value="검색" />  

</form>

<form name="del" action="delete" method="post">
	<input type="hidden" name="id">
</form>




</center>



</body>
</html>




