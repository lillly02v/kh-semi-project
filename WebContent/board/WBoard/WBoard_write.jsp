<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>복지자 참여 등록하기</title>
<link href="css/write.css" rel="stylesheet">
<script src="./js/jquery-3.3.1.js"></script>
</head>
<body>
<%@ include file="../../header/Header.jsp" %>
<%-- <%@ include file="/board/header.jsp" %>--%>
		<img style="margin-left:10%; margin-top:3%;" src="images/home(dabong).png">&nbsp;>&nbsp;봉사자 글쓰기
	<p style="text-align:left;" id="qav_head" class="vbo_head"><br><br>
		<strong style="font-size:40px; margin-left:9%">복지자 글쓰기 </strong>
	<br><br><br>
	<a style="margin-left:9%">복지자가 글을 수정하는 곳입니다.</a><br><br><br></p>
<form action="./wboardAddAction.wb" method="post" class="wblist-form"
	enctype="multipart/form-data" name="boardform">
	<table id="table">
		<tr class="center">
			<th class="title"colspan="2" ><h3 style="color:white;">복지자 글쓰기</h3></th>
		</tr>
		<tr>
			<td><div id="center">아이디</div></td>
			<td>
				<input name="wid" id="wid" type="text" 
					size="100%" maxlength="30" value="${sessionScope.id}" readonly>
			</td>
		</tr>
		<tr>
			<td><div id="center">글쓴이</div></td>
			<td>
				<input name="wname" id="wname"
					type="text" size="100%" maxlength="30" value="${sessionScope.name }" readonly>
			</td>
		</tr>
		<tr>
			<td><div id="center">비밀번호</div></td>
			<td>
				<input name="wpass" id="wpass"
					type="password" size="100%" maxlength="30" value="" required>
			</td>
		</tr>
		<tr>
			<td><div id="center">제목</div></td>
			<td><input name="wbsub" id="wbsub"
					type="text" size="100%" maxlength="100" value="" required>
		</tr>
		<tr>
			<td><div id="center">복지가능 요일</div></td>
			<td><input type="radio" name="wbweek" id="wbweek1" value="월요일" checked>월요일
			<input type="radio" name="wbweek" id="wbweek2" value="화요일">화요일
			<input type="radio" name="wbweek" id="wbweek3" value="수요일">수요일
			<input type="radio" name="wbweek" id="wbweek4" value="목요일">목요일
			<input type="radio" name="wbweek" id="wbweek5" value="금요일">금요일
			<input type="radio" name="wbweek" id="wbweek6" value="토요일">토요일
			<input type="radio" name="wbweek" id="wbweek7" value="일요일">일요일
			<input type="radio" name="wbweek" id="wbweek8" value="무관">무관
			</td>
		
		</tr>
		<tr>
			<td><div id="center">복지가능 시간</div></td>
			<td><input type="radio" name="wbpostime" id="wbpostime1" value="오전" checked>오전
			<input type="radio" name="wbpostime" id="wbpostime2" value="오후">오후
			<input type="radio" name="wbpostime" id="wbpostime3" value="종일">종일
			<input type="radio" name="wbpostime" id="wbpostime4" value="시간협의" >시간협의
			
			</td>
		</tr>
		<tr>
			<td><div id="center">복지자 지역</div></td>
			<td><input type="radio" name="wbarea" id="wbarea1" value="서울" checked>서울
			<input type="radio" name="wbarea" id="wbarea2" value="부산">부산
			<input type="radio" name="wbarea" id="wbarea3" value="대구">대구
			<input type="radio" name="wbarea" id="wbarea4" value="인천">인천
			<input type="radio" name="wbarea" id="wbarea5" value="광주">광주
			<input type="radio" name="wbarea" id="wbarea6" value="대전">대전
			<input type="radio" name="wbarea" id="wbarea7" value="울산">울산
			<input type="radio" name="wbarea" id="wbarea8" value="세종">세종
			<input type="radio" name="wbarea" id="wbarea9" value="경기">경기
			<input type="radio" name="wbarea" id="wbarea10" value="강원">강원
			<input type="radio" name="wbarea" id="wbarea11" value="충북">충북
			<input type="radio" name="wbarea" id="wbarea12" value="충남">충남
			<input type="radio" name="wbarea" id="wbarea13" value="전북">전북
			<input type="radio" name="wbarea" id="wbarea14" value="전남">전남
			<input type="radio" name="wbarea" id="wbarea15" value="경북">경북
			<input type="radio" name="wbarea" id="wbarea16" value="경남">경남
			<input type="radio" name="wbarea" id="wbarea17" value="제주">제주
	
		</tr>
		<tr>
			<td><div id="center">종교</div></td>
			<td><input type="radio" name="wbrelig" id="wbrelig1" value="기독교" checked>기독교
			<input type="radio" name="wbrelig" id="wbrelig2" value="이슬람교">이슬람교
			<input type="radio" name="wbrelig" id="wbrelig3" value="유대교">유대교
			<input type="radio" name="wbrelig" id="wbrelig4" value="불교" >불교
			<input type="radio" name="wbrelig" id="wbrelig5" value="무교" >무교
			
		</tr>
		<tr>
			<td><div id="center">봉사자 성별</div></td>
			<td><input type="radio" name="wbgenv" id="wbgenv1" value="남성" checked>남성
			<input type="radio" name="wbgenv" id="wbgenv2" value="여성">여성
			<input type="radio" name="wbgenv" id="wbgenv3" value="무관">무관
			
			</td>
		</tr>
		<tr>
			<td><div id="center">희망 복지</div></td>
			<td><input type="radio" name="wbhope" id="wbhope1" value="건강" checked>건강
			<input type="radio" name="wbhope" id="wbhope2" value="고용">고용
			<input type="radio" name="wbhope" id="wbhope3" value="보육/교육">보육/교육
			<input type="radio" name="wbhope" id="wbhope4" value="생활/안전">생활/안전
			<input type="radio" name="wbhope" id="wbhope5" value="주거">주거
			</td>
		</tr>
		<tr>
			<td><div id="center">희망 봉사자 경력</div></td>
			<td><select name="wbhopeve" id="wbhopeve">
			<option value="3개월 미만">3개월 미만</option>
			<option value="3개월 이상 ~ 6개월 미만">3개월 이상 ~ 6개월 미만</option>
			<option value="6개월 이상 ~ 1년 미만">6개월 이상 ~ 1년 미만</option>
			<option value="1년 이상">1년 이상</option>
			<option value="5년 이상">5년 이상</option>
			<option value="10년 이상">10년 이상</option>
			<option value="기타">기타
			</select>
		</tr>
		<tr>
			<td><div id="center">내용</div></td>
			<td><textarea name="wbcont" id="wbcont"
						cols="101.8" rows="20" required></textarea>
			</td>
		</tr>
		<tr>
			<td><div id="center">파일 첨부</div></td>
			<td><input type="file" id="upfile" name="wbfile"></td>
		</tr>
</table>
		<br>
		<table style="margin:auto;">	
				<tr>
				<th>
				<input style="background:#5D5D5D; color:white; border:0; height:50px; line-height: 28px; border-radius:3px; width: 200px;" type=submit value="등록">
				<input style="background:#5D5D5D; color:white; border:0; height:50px; line-height: 28px; border-radius:3px; width: 200px;" type=reset value="취소" onClick="history.go(-1)">
				</th>
				</tr>
				</table>
</form>
<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
<%@ include file="../../footer/Footer.jsp" %>
</body>
</html>