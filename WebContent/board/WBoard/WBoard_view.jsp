<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<title>복지자 참여 내용 확인하기</title>
<link type="text/css" rel="stylesheet" href="./css/view.css" />
<script src="./js/jquery-3.3.1.js"></script>
<script src="./js/match.js"></script>
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
<script>
	
	$(document).ready(function(){
		matchingbtn("wrSendMatch.net");
	});
	
</script>


</head>
<body>
<%@ include file="../../header/Header.jsp" %>
	<img style="margin-left:10%; margin-top:3%;" src="images/home(dabong).png">&nbsp;>&nbsp;복지자참여
	<p style="text-align:left;" id="qav_head" class="vbo_head"><br><br>
		<strong style="font-size:40px; margin-left:9%">복지자 참여 </strong>
	<br><br><br>
	<a style="margin-left:9%">복지자가 직접 등록한 복지서비스 게시판 입니다.</a><br><br><br></p>
	<table class="name">
	<tr class="title">
		<c:set var="bd" value="${boardDetail}"/>
		<td>
			<h2 class="h2_style">${bd.wbsub}</h2>
		</td>
		<td>
		<td>
		<h4 class="h4_style0">${bd.wbdate}</h4>
		</td>
		</tr>
		<tr>
		<td>
		<h4 class="h4_style1">${bd.wname}</h4>
		</td>
		<td>
		<h4 class="h4_style">조회${bd.wbreadcount}</h4>
		</td>
		</tr>
		</table>
		<hr class="my-hr1">
		<br>	
		<table class="blueone">
		<tr><th>복지자 정보</th>
	</tr>
	<tr>
		<td>복지가능 요일</td><td>복지가능 시간</td><td>복지가능 지역</td><td>종교</td><td>복지자 성격</td><td>희망 복지</td><td>희망 봉사가 경력</td>
	</tr>
		<tr>
			<td>${bd.wbweek}</td><td>${bd.wbpostime}</td><td>${bd.wbarea}</td><td>${bd.wbrelig}</td><td>${bd.wbgenv}</td>
			<td>${bd.wbhope}</td><td>${bd.wbhopeve}</td>
		</tr>
		</table>
		<br>
		<br>
		<br>
		<table class="name">
		<tr>
		<td>
		<div  class="middle">

			<pre>${bd.wbcont}</pre>
			<c:if test="${!empty boardDetail.wbfile}">
			<img src="./boardupload/${boardDetail.wbfile}" width="300px" height="300px">
			</c:if>
		<h5>첨부 파일 다운로드</h5>
			<c:if test="${!empty boardDetail.wbfile}">
			
				<img src="./images/down.png" width="10px">
				<a href="./wboardFileDownAction.wb?filename=${boardDetail.wbfile}">
					${bd.wbfile}</a>
			
			</c:if>
			</div>
			<br>
			<br>
			<br>
		</td>
		</tr>
		</table>
		<hr class="my-hr1">
				<c:if test="${sessionScope.user == '봉사자' || sessionScope.id == 'admin'}">
			<form class="match-form" method="post" action='wrSendMatch.net'>
				<input type="hidden" class="boardNum" name="boardNum" value="${bd.wbnum}">
				<input type="hidden" class="requestMB" name="requestMB" value="${sessionScope.id}">
				<input type="hidden" class="responseMB" name="responseMB" value="${bd.wid}">
				<input type="hidden" class="choiceVal" name="choiceVal" value="choice">
				<center><input type="submit" class="button matchbtn" value="매칭하기"></center>
			</form>
		</c:if>
	<br>
			<table style="margin:auto;">
				
				<tr>
			<td colspan="2" class="center"  >
				<c:if test="${((sessionScope.user == '복지자') && (sessionScope.id == boardDetail.wid)) || (sessionScope.id == 'admin')}">
					<input type="button" onclick="location.href='./wboardModifyView.wb?num=${boardDetail.wbnum}'" class="bottom_button"value="수정" >&nbsp;&nbsp;
					
					<input type="button" onclick="location.href='./wboardDelete.wb?num=${boardDetail.wbnum}'" class="bottom_button"value="삭제">&nbsp;&nbsp;
				</c:if>
				<input type="button" onclick="location.href='./wboardList.wb'" class="bottom_button"value="목록">&nbsp;&nbsp;
				
		</td>
		</tr>
	</table>
	<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<%@ include file="../../footer/Footer.jsp" %>
</body>
</html>