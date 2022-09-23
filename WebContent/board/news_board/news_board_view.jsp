<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>뉴스 상세보기</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<link href="./css/css_kh/view.css" rel="stylesheet" type="text/css">
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
#myBtn {
  display: none;
  position: fixed;
  bottom: 106px;
  right: 50%;
  z-index: 99;
  font-size: 18px;
  border: none;
  outline: none;
  background-color: #b9b9b9;
  color: white;
  cursor: pointer;
  padding: 20px;
  border-radius: 4px;
  
}
#myBtn:hover {
  background-color: #555;
}
</style>
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
    $( 'html, body' ).animate( { scrollTop : 0 }, 1000 );
    return false;
  } );
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
      <form action="./net.board.news.action/NewsBoardAddAction.news"
         method="post" name="boardform">
         <c:set var="bd" value="${detail}" />
         </form>
   <div class="sub">
         <h3>&nbsp;&nbsp;${bd.nesub}</h3>
         <h4>&nbsp;&nbsp;글쓴이 ${bd.aname}&nbsp;<img src="./boardupload/admin.jpg" id="jpg">
            &nbsp;&nbsp;&nbsp;&nbsp;작성일 ${bd.nedate}
            &nbsp;&nbsp; 조회수 ${bd.nevisit}</h4>
   </div>
   <br>
   <div class="down">첨부 된 파일 : ${bd.nefiles}</div>
   <br>
   <br>      
   <table class="viewCont">
      <tr>
         <td>
            <pre>${bd.necont}</pre> 
 
         </td>
      </tr>
   </table>
   	<div id="choice" style="text-align:center">
   	<c:if test="${sessionScope.id == 'admin'}">
     
        <a href="./NewsBoardModifyView.news?num=${num}">
        수정</a>&nbsp;&nbsp;
        
        <a href="./NewsBoardDelete.news?num=${num}">
        삭제</a>&nbsp;&nbsp;
    </c:if>
      <c:if test="${sessionScope.fload == 'album' }">
           <a href="./news_board_album.news">목록</a>&nbsp;&nbsp;
        </c:if>      
        <c:if test="${sessionScope.fload == 'list' }">
           <a href="./news_board_list.news">목록</a>&nbsp;&nbsp;
        </c:if>
    </div>
   
   <table class="asdf" style="">
      <c:if test="${num == 1}">
         <tr>
            <td width="20">&nbsp;&nbsp;▲ 다음글</td>
            <td width="60">
            <a href="./NewsBoardDetailAction.news?num=${afterdetail.nenum}">
                  ${afterdetail.nesub}</a>&nbsp;&nbsp;
            </td>
            <td width="20">${afterdetail.nedate}</td>
         </tr>
      </c:if>
      
      <c:if test="${num > 1 && num < max}">
         <tr>
            <td width="20">&nbsp;&nbsp;▲ 다음글</td>
            <td width="60">
            <a href="./NewsBoardDetailAction.news?num=${afterdetail.nenum}">
                  ${afterdetail.nesub}</a>
             </td>
             <td width="20">${afterdetail.nedate} <br> 
          </tr>
          
          <tr>
          	<td width="20">&nbsp;&nbsp;▼ 이전글</td>
         	<td width="60">
         	<a href="./NewsBoardDetailAction.news?num=${beforedetail.nenum}">
                  ${beforedetail.nesub}</a>
            </td>
            <td width="20">${beforedetail.nedate} </td>
         </tr>
      </c:if>

      <c:if test="${num == max}">
         <tr>
          	<td width="20">&nbsp;&nbsp;▼ 이전글</td>
         	<td width="60">
         	<a href="./NewsBoardDetailAction.news?num=${beforedetail.nenum}">
                  ${beforedetail.nesub}</a>
            </td>
            <td width="20">${beforedetail.nedate}</td>
         </tr>
      </c:if>
   </table>
   <button onclick="topFunction()" class='top' id="myBtn" title="Go to top">Top</button>
	<br><br><br>
	<br><br><br>
	<br><br><br>
	<br><br>
</body>
<%@ include file="../../footer/Footer.jsp" %>
</html>