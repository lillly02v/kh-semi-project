<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>정보마당 앨범형</title>
<script src="./js/jquery-3.3.1.js"></script>
<link href="./css/album.css" rel="stylesheet" type="text/css">
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
.home-img {
    width:16px; 
    height:16px;
    border-radius:0px;
}
</style>
<script>   //버튼클릭 스크립트
$(document).ready(function(){
   $('#1').on('click', function(){
      location.href="./news_board_album.news";
   });
   $('#2').on('click', function(){
      location.href="./news_board_list.news";
   });
});
</script>

<script>   //최상단 스크립트
$( document ).ready( function() {
  $( window ).scroll( function() {
    if ( $( this ).scrollTop() > 50 ) {
      $( '.top' ).fadeIn();
    } else {
      $( '.top' ).fadeOut();
    }
  } );
  $( '.top' ).click( function() {
    $( 'html, body' ).animate( { scrollTop : 0 }, 1000 );   //스크롤 올라가는 시간
    return false;
  } );
});
</script>

<script>   //무한스크롤 스크립트
$( document ).ready( function() {
   var page = 2;
   $(window).scroll(function(){
        setTimeout(function() {      //달라붙는 시간 설정   
      if($(window).scrollTop() == $(document).height() - $(window).height()){
            var sendData = 'page=' + page;
            var test= 1;
            
            $.getJSON("news_board_album.news", sendData, function(obj){
            var output = '';
               $(obj).each(function(index, item){
                  if(test%4==1){
                     output += '<tr style="text-align:center;">';
                  }
                  output += '<td style="text-align:center"><div>' 
                  + '<a href="./NewsBoardDetailAction.news?num=' + item.nenum + '">';
                  
                  if(item.files != null){
                     output += '<img src="boardupload/' +item.files +'"><br></a>';
                  } else if(item.files == null){
                     output += '<img src="boardupload/dabong.JPG"><br></a></div>';
                  }
                  
                  output += '<div class="target" style="font-weight:bold;" >'
                  + '<a href="./NewsBoardDetailAction.news?num=' + item.nenum + '">'+ item.sub+'</a></div><br>'
                  + "조회 "+item.visit + " | " + item.date+'<br>'
                  + '<div style="text-align: center"><font size=2>' + item.name+ '</font>' 
                  + '<img src="boardupload/admin.jpg" id="jpg">'+'<br><br><br></td>';
                  
                  if(test%4==0){
                     output += '</tr>';
                  }
                  //alert(output);
                  test= test+1;
                  /* alert(index+'====='+Object.values(item.date)); */
               });
               $('tbody').append(output);
            });
            page = page + 1;
         }
      }, 2000);   //1초 뒤
   });
});
</script>


<%@ include file="../../header/Header.jsp" %>
</head>
<body>
	<img style="margin-left:10%; margin-top:3%;" class="home-img" src="./images/home(dabong).png">&nbsp;>&nbsp;정보마당
	<p style="text-align:left;" id="qav_head" class="vbo_head"><br><br>
		<strong style="font-size:40px; margin-left:9%">정보 마당 </strong>
	<br><br><br>
	<a style="margin-left:9%">복지 관련 정보를 볼 수 있는 게시판입니다.</a><br><br><br></p>   
      <span class="nbutton-span">
      <button id="1" class="nbutton1">앨범형</button>
      <button id="2" class="nbutton1">리스트형</button>
      </span>
      <c:if test="${sessionScope.id == 'admin'}">
      <a href="./news_board_write.news" style="text-align: center" id="write">
      <button class="nbutton3">글쓰기</button><br>
      </a>
      </c:if>
   <%--검색 --%>   
   <span class="pageNum" style="line-height:60px"><font size="4" style="margin-left:9.5%">총 게시물 수 <b style="color:#1E90FF"> ${listcount}</b></font></span>
      <form action="news_board_album.news" method="get" id="searchForm">
            <select name="opt">
               <option value="0">선택</option>
                <option value="1">제목</option>
                <option value="2">내용</option>
                <option value="3">제목+내용</option>
               </select>
            <input type="text" size="20" name="condition"/>&nbsp;
            <input type="submit" value="검색"/>
      </form>
      <br>
      
   <table class="album album-table">
      <c:set var="num" value="${listcount-(page-1) * 12}" />
      <%--4개 씩 --%>
      <c:set var="i" value="0" />
      <c:set var="j" value="4" />
      <c:forEach var="b" items="${boardlist}">
      
      <c:if test="${i % j == 0}">
         <tr>
      </c:if>
            <td class="news-td" style="text-align:center">
               <c:set var="num" value="${num-1}" /> <%-- num = num - 1 --%>
               <%-- 첨부파일 썸네일 --%>
                  <div style="text-align:center">
                     <a href="./NewsBoardDetailAction.news?num=${b.nenum}">
                        <c:if test="${b.nefiles != null}">
                           <img src="./boardupload/${b.nefiles}">
                        </c:if> 
                  
               <%--첨부 파일이 없을 때 썸네일 이미지 --%>
                        <c:if test="${b.nefiles == null}">
                        <img src="./boardupload/dabong.JPG">
                        <br>
                        </c:if>
                     </a>
                  </div>
               
               <%--게시물 형식 --%>
               <div class="target" style="text-align:center; font-weight:bold">
                  <a href="./NewsBoardDetailAction.news?num=${b.nenum}">
                     <font size=4>${b.nesub}</font></a>
               </div>
               <div style="text-align: center"><font size=3>조회 ${b.nevisit} | ${b.nedate}</font></div>
               <div style="text-align: center"><font size=2>${b.aname}</font> 
               <img src="./boardupload/admin.jpg" id="jpg">
               </div>
               <div class="enterdiv">
                  <br><br>
               </div>
            </td>
         <c:if test="${i % j == j - 1}">
         
         </c:if>
         <c:set var="i" value="${i + 1}"/>
      </c:forEach>
      
      <!-- 레코드가 없으면 -->
		<c:if test="${listcount == 0}">
			<tr>
				<td style="text-align: center" colspan="4">
					<font size=2>등록된 글이 없습니다.</font>
				</td>
			</tr>
		</c:if>
	</table>
	<button onclick="topFunction()" class='top' id="myBtn" title="Go to top">Top</button>
    <br>
	<br>
    <br>
    <br>
	<br>
    <br>
</body>
<%@ include file="../../footer/Footer.jsp" %>
</html>