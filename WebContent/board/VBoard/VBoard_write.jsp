<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>봉사자 참여 등록하기</title>
<link href="./css/write.css" rel="stylesheet">
<script src="./js/jquery-3.3.1.js"></script>
</head>
<body>

<%@ include file="../../header/Header.jsp" %>
	<img style="margin-left:10%; margin-top:3%;" src="./images/home(dabong).png">&nbsp;>&nbsp;봉사자 글쓰기
	<p style="text-align:left;" id="qav_head" class="vbo_head"><br><br>
		<strong style="font-size:40px; margin-left:9%">봉사자 글쓰기 </strong>
	<br><br><br>
	<a style="margin-left:9%">봉사자가 글을 수정하는 곳입니다.</a><br><br><br></p>
<form style="" action="./vboardAddAction.vb" method="post"
	enctype="multipart/form-data" name="boardform">
	<table id="table">
		<tr class="center">
			<th class="title"colspan="2"><h3 style="color:white;">봉사자 글쓰기</h3></th>
		</tr>
		<tr>
			<td><div id="center">아이디</div></td>
			<td>
				<input name="vid" id="vid" 
					type="text" size="100%" maxlength="30" value="${sessionScope.id}" readonly>
			</td>
		</tr>
		<tr>
			<td><div id="center">글쓴이</div></td>
			<td>
				<input name="vname" id="vname" 
					type="text" size="100%" maxlength="30" value="${sessionScope.name}" readonly>
			</td>
		</tr>
		<tr>
			<td><div id="center">비밀번호</div></td>
			<td>
				<input name="vpass" id="vpass"
					type="password" size="100%" maxlength="30" value="">
			</td>
		</tr>
		<tr>
			<td><div id="center">제목</div></td>
			<td><input name="vbsub" id="vbsub"
					type="text" size="100%" maxlength="100" value="">
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
						cols="67" rows="5">${boardData.vbexcont}</textarea>
			</td>
		</tr>
		<tr>
			<td><div id="center">내용</div></td>
			<td><textarea name="vbcont" id="Vbcont" 
						cols="67" rows="15">${boardData.vbcont}</textarea>
			</td>
		</tr>
		<tr>
			<td><div id="center">파일 첨부</div></td>
			<td><input type="file" id="upfile" name="vbcerti"></td>
		</tr>
	</table>
		<br>
		<table style="margin:auto;">	
				<tr>
				<th>
				<input style="background:#5D5D5D; color:white; border:0; height:50px; line-height: 28px; border-radius:3px; width: 200px;" type=submit value="등록" class="input-text">
				<input style="background:#5D5D5D; color:white; border:0; height:50px; line-height: 28px; border-radius:3px; width: 200px;" type=reset value="취소" class="cancle-text" onClick="history.go(-1)">
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