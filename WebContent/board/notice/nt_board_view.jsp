<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="./css/view.css" rel="stylesheet">
<style>
#qav_head {
	background: url(./css/images/modal-3.jpg);
	background-repeat: no-repeat;
	background-size: cover;
	background-position: center;
	border: 1px solid #dedede;
	color: white;
	padding: 10px;
	margin-top: 15px;
	width: 100%;
}

.vbo_head {
	position: relative;
	padding: 0 0 10px;
	width: auto;
	border-bottom: 1px solid #eceff3;
	line-height: 1.5em;
	margin-bottom: 10px;
}
</style>
</head>
<body>
	<%@ include file="../../header/Header.jsp"%>
	<c:set var="bd" value="${boardDetail}" />
	<br>
	<img style="margin-left: 10%; margin-top: 3%;"
		src="./images/home(dabong).png">&nbsp;>&nbsp;공지사항
	<p style="text-align: left;" id="qav_head" class="vbo_head">
		<br>
		<br> <strong style="font-size: 40px; margin-left: 9%">공지사항
		</strong> <br>
		<br>
		<br> <a style="margin-left: 9%">봉사자, 복지자에게 신속히 알려드릴 필요성이 있는
			자료를 제공해 드립니다.</a><br>
		<br>
		<br>
	</p>

	<br>
	<br>
	<table class="name">
		<tr class="title">
			<td>
				<h2 class="h2_style">${bd.ntsub}</h2>
			</td>
			<td>
				<h4 class="h4_style0">${bd.ntdate}</h4>
			</td>
		</tr>
		<tr>
			<td>
				<h4 class="h4_style1">${bd.aname}</h4>
			</td>
			<td>
				<h4 class="h4_style">${bd.ntvisit}</h4>
			</td>
		</tr>
	</table>
	<hr class="my-hr1">
	<table class="name">
		<tr>
			<td>
				<div class="middle">
					<pre>${bd.ntcont}</pre>
					<h5>첨부 파일 다운로드</h5>
					<c:if test="${!empty bd.ntfiles}">
						<a href="./NTBoardFileDown.nt?filename=${bd.ntfiles}">
							${bd.ntfiles}</a>
					</c:if>
				</div> <br> <br> <br>
			</td>
		</tr>
	</table>
	<hr class="my-hr1">
	<table style="margin: auto;">
		<tr>
			<td colspan="2" class="center">
			<%--<c:if test="${sessionScope.id == 'admin'}">--%>
			
					 <c:if test="${sessionScope.id == 'admin'}"> 
					<input type="button"
						onclick="location.href='./NTBoardModifyView.nt?num=${bd.ntnum}'"
						class="bottom_button" value="수정">
				&nbsp;&nbsp;
				
				<input type="button"
						onclick="location.href='./NTBoardDelete.nt?num=${bd.ntnum}'"
						class="bottom_button" value="삭제">
				&nbsp;&nbsp;
			</c:if> 
			
			<input type="button" onclick="location.href='./NTBoardList.nt'"
				class="bottom_button" value="목록">&nbsp;&nbsp;</td>
		</tr>
	</table>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<%@ include file="../../footer/Footer.jsp"%>
</body>
</html>