<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
	<title>JSTL</title>
</head>
<body>
<%-- page Scope 저장소에 저장 (EL은 lv 사용X) --%>
<c:set var="to"   value="10"/>
<c:set var="arr"  value="10,20,30,40,50,60,70"/> 
<c:forEach var="i" begin="1" end="${to}">
	${i}
</c:forEach>
<br>

<c:if test="${not empty arr}">
	<c:forEach var="elem" items="${arr}" varStatus="status">
		<%-- count는 1부터 시작, index는 0부터 시작 --%>
		${status.count}. arr[${status.index}]=${elem}<BR>
	</c:forEach>
</c:if>

<c:if test="${param.msg != null}">
	<%-- 입력된 걸 그대로 사용 (html 태그 반영), script 공격에 취약 --%>
	msg=${param.msg}

	<%-- 받은 문자 그대로 출력 ex. <p>msg</p> 를 그대로 출력한다 (태그로 해석X) --%>
	msg=<c:out value="${param.msg}"/>
</c:if>
<br>

<c:if test="${param.msg == null}">메시지가 없습니다.<br></c:if>

<c:set var="age" value="${param.age}"/>
<c:choose>
	<c:when test="${age >= 19}">성인입니다.</c:when>
	<c:when test="${0 <= age && age < 19}">성인이 아닙니다.</c:when>
	<c:otherwise>값이 유효하지 않습니다.</c:otherwise>
</c:choose>
<br>

<c:set var="now" value="<%=new java.util.Date() %>"/>
Server time is <fmt:formatDate value="${now}" type="both" pattern="yyyy/MM/dd HH:mm:ss"/>

</body>
</html>

<%-- 실행 결과
1 2 3 4 5 6 7 8 9 10
1. arr[0]=10
2. arr[1]=20
3. arr[2]=30
4. arr[3]=40
5. arr[4]=50
6. arr[5]=60
7. arr[6]=70

메시지가 없습니다.
값이 유효하지 않습니다.
Server time is 2022/11/24 14:10:12
--%>


