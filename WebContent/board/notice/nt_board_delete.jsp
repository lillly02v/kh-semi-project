<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="./css/form.css" rel="stylesheet">
</head>
<body>
<jsp:include page="../../header/Header.jsp" />
	<form name="deleteForm" action="./NTBoardDeleteAction.nt" method="get">
		<input type="hidden" name="num" value="${param.num}">
		<table border="1">
			<tr>
				<td><h1>삭제 하시겠습니까?</h1></td>
			</tr>
			<tr>
				<td colspan=2 class="h30 center lime">
					<input type="submit" value="삭제">
					<input type="button" value="취소" onClick="history.go(-1)">
				</td>
			</tr>
		</table>
	</form>
<jsp:include page="../../footer/Footer.jsp" />
</body>
</html>