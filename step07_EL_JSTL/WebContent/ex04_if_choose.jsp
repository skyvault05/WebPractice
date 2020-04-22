<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<h1>&lt;c:if>, &lt;c:choose> TEST</h1>
 <c:if test="${param.age > 18}" >
 	<h3>${param.age} 살은 성인입니다.</h3>
 </c:if>
 
 <hr>
 
 <c:choose >
 	<c:when test="${param.age>18}">
 		<h3 style="color:blue">${param.age}살은 성인입니다</h3>
 	</c:when>
 	<c:otherwise>
 		<h3 style="color:red">${param.age}살은 미성년자입니다</h3>
 	</c:otherwise>
 </c:choose>
 
 <hr>
 
 <form action="ex04_if_choose.jsp" method="get" name="f">
 	이름 : <input type="text" name="name"><br>
 	선택 :
 	<select name="job">
 		<option value="0" style="display:none;">--선택--</option>
 		<option value="학생">학생</option>
 		<option value="개발자">개발자</option>
 		<option value="백조">백조</option>
 		<option value="백수">백수</option>
 	</select>
 	
 	<input type="submit" value="전송"/>
 </form>
 
 <h3>
 	<c:if test="${param.name!=null}">
 	${param.name}님 직업은 ${param.job}입니다.
 	</c:if>
 	
 </h3>
 
<c:if test="${not empty param.job}">
	<c:choose>
	 	<c:when test="${param.job=='학생'}">
	 		<h1>공부하세요</h1>
	 	</c:when>
	 	<c:when test="${param.job=='개발자'}">
	 		<h1>최고의 개발자가 되세요</h1>
	 	</c:when>
	 	<c:when test="${param.job=='백조'}">
	 		<h1>노세 노세 젋어서 노세</h1>
	 	</c:when>
	 	<c:when test="${param.job=='백수'}">
	 		<h1>돈 버세요...</h1>
	 	</c:when>
	 	<c:otherwise>
	 		<h1>선택사항 없음</h1>
	 	</c:otherwise> 	
	</c:choose>
</c:if>
 
 <script type="text/javascript">
 	document.f.job.value="${param.job}";
 </script>
 
</body>
</html>