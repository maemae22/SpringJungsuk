<%-- TwoDiceServlet.java 랑 동일한 파일이니 비교하면서 확인해보기 ! --%>

<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.util.Random" %>
<%-- <%! 클래스 영역 %> : iv, cv 선언 --%>
<%!  
	int getRandomInt(int range){
		return new Random().nextInt(range)+1;
	}
%>
<%-- <%  메서드 영역 - service()의 내부 %> : lv 선언 --%>
<%
	int idx1 = getRandomInt(6);
	int idx2 = getRandomInt(6);
%>
<html>
<head>
	<title>twoDice.jsp</title>
</head>
<body>
	<img src='resources/img/dice<%=idx1%>.jpg'>
	<img src='resources/img/dice<%=idx2%>.jpg'>
</body>
</html>
