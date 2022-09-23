<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>봉사자 참여 내용 수정하기</title>
</head>
<script src="./js/jquery-3.3.1.js"></script>
<link href="./css/write.css" rel="stylesheet">

<body>
<%@ include file="../../header/Header.jsp" %>
<br>
		<br>
		<br>
	<form action="./vboardModifyAction.vb" method="post" name="boardform">
	<input type="hidden" name="num" value="${param.num}">
		<table id="table" >
			<tr class="center">
				<th class="title"colspan="2"><h3 style="color:white;">게시판 수정</h3></th>
			</tr>
			<tr>
				<td><div id="center">글쓴이</div></td>
				<td>
					<input type="text" name="vname" id="vname" value="${sessionScope.id}" readonly>
				</td>
			</tr>
			<tr>
			<td><div id="center">제목</div></td>
			<td><input name="vbsub" id="vbsub"
					type="text" size="50" maxlength="100" value="${vboardData.vbsub}">
		</tr>
		<tr>
			<td><div id="center">봉사가능 요일</div></td>
			<td><input type="checkbox" name="vbweek" id="vbweek1" value="월요일">월요일
			<input type="checkbox" name="vbweek" id="vbweek2" value="화요일">화요일
			<input type="checkbox" name="vbweek" id="vbweek3" value="수요일">수요일
			<input type="checkbox" name="vbweek" id="vbweek4" value="목요일">목요일
			<input type="checkbox" name="vbweek" id="vbweek5" value="금요일">금요일
			<input type="checkbox" name="vbweek" id="vbweek6" value="토요일">토요일
			<input type="checkbox" name="vbweek" id="vbweek7" value="일요일">일요일
			<input type="checkbox" name="vbweek" id="vbweek8" value="무관">무관
			</td>
		</tr>
		<tr>
			<td><div id="center">봉사가능 시간</div></td>
			<td><input type="checkbox" name="vbpostime" id="vbpostime1" value="오전">오전
			<input type="checkbox" name="vbpostime" id="vbpostime2" value="오후">오후
			<input type="checkbox" name="vbpostime" id="vbpostime3" value="종일">종일
			<input type="checkbox" name="vbpostime" id="vbpostime4" value="시간협의">시간협의
			
			</td>
		</tr>
				<tr>
			<td><div id="center">봉사자 성격</div></td>
			<td><input type="checkbox" name="vbchrac" id="vbchrac1"value="쾌활함">쾌활함
			<input type="checkbox" name="vbchrac" id="vbchrac2" value="차분함">차분함
			<input type="checkbox" name="vbchrac" id="vbchrac3"value="명량함">명량함
			<input type="checkbox" name="vbchrac" id="vbchrac4" value="활동적임">활동적임
			</td>
		</tr>
		<tr>
			<td><div id="center">봉사자 지역</div></td>
			<td><select name="vbarea" id="vbarea" style="width: 100px;">
			<option value="서울">서울</option>
			<option value="부산">부산</option>
			<option value="대구">대구</option>
			<option value="인천">인천</option>
			<option value="광주">광주</option>
			<option value="대전">대전</option>
			<option value="울산">울산</option>
			<option value="세종">세종</option>
			<option value="경기">경기</option>
			<option value="강원">강원</option>
			<option value="충북">충북</option>
			<option value="충남">충남</option>
			<option value="전북">전북</option>
			<option value="전남">전남</option>
			<option value="경북">경북</option>
			<option value="경남">경남</option>
			<option value="제주">제주</option>
			
			
			</select>
		</tr>
		<tr>
			<td><div id="center">종교</div></td>
			<td><select name="vbrelig" id="vbrelig" style="width: 100px;">
			<option value="기독교">기독교</option>
			<option value="이슬람교">이슬람교</option>
			<option value="유대교">유대교</option>
			<option value="불교">불교</option>
			<option value="무교">무교</option>
			
			
			</select>
		</tr>
		<tr>
			<td><div id="center">봉사경험유무</div></td>
			<td><select name="vbexper" id="vbexper" style="width: 100px;">
			<option value="있음">있음</option>
			<option value="없음">없음</option>
			</select>
		</tr>
		<tr>
			<td><div id="center">봉사경험내용</div></td>
			<td><textarea name="vbexcont" id="vbexcont" 
						cols="67" rows="5">${vboardData.vbexcont}</textarea>
			</td>
		</tr>
		<tr>
			<td><div id="center">내용</div></td>
			<td><textarea name="vbcont" id="vbcont" 
						cols="67" rows="15">${vboardData.vbcont}</textarea>
			</td>
		</tr>
		<tr>
			<td><div id="center">비밀번호</div></td>
			<td>
				<input name="vpass" id="vpass"
					type="password" size="10" maxlength="30">
					
			</td>
		</tr>
		<tr>
			<td><div id="center">첨부 파일</div></td>
						<c:if test="${!empty vboardData.vbcerti}">
			<td>
				&nbsp;&nbsp;${vboardData.vbcerti}
			</td>
			</c:if>
		</tr>
		</table>
	
	<br>
	<table style="margin:auto;">	
				<tr>
				<th>
				<input type="submit"  style="background:#5D5D5D; color:white; border:0; height:30px; width: 100px; line-height: 28px; border-radius:3px;" value="등록">
				<input type="reset"	 style="background:#5D5D5D; color:white; border:0; height:30px; width: 100px; line-height: 28px; border-radius:3px;"value="취소"	onClick="history.go(-1)">
				</th>
				</tr>
				</table>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		</form>
<%@ include file="../../footer/Footer.jsp"%>
</body>
</html>