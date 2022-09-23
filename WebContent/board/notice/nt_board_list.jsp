<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html id='html'>
<head>
<meta charset="UTF-8">
<title>공지 게시판</title>
<link href="./css/list.css" rel="stylesheet">
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
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
<jsp:include page="../../header/Header.jsp" />
<img style="margin-left:10%; margin-top:3%;" src="./images/home(dabong).png">&nbsp;>&nbsp;공지사항
	<p style="text-align:left;" id="qav_head" class="vbo_head"><br><br>
		<strong style="font-size:40px; margin-left:9%">공지사항 </strong>
	<br><br><br>
	<a style="margin-left:9%">봉사자, 복지자에게 신속히 알려드릴 필요성이 있는 자료를 제공해 드립니다.</a><br><br><br></p>
    <table style="width:100%; text-align:center;">
		<tr>
			<th colspan="4">
			<select name="opt" id="select" size="1" style="height:38px; width:200px; font-size:12px; vertical-align: middle;" >
					<option>선택</option>
                	<option value="0">제목</option>
                	<option value="1">내용</option>
                	<option value="2">제목+내용</option>
			</select>&nbsp;<input class="search__input" name="condition" type="text" placeholder="검색어를 입력하세요..">
			<input style="background:#5D5D5D; color:white; border:1px; height:38px; line-height: 28px; vertical-align: middle;" type="submit" name="search"value="검색"/></th>
				</tr>
			</table>
			<br>
			<br>
			<br>
    <table class="list">
      <tr >
        <th width="8%" ><div>번호</div></th>
        <th width="50%"><div>제목</div></th>
        <th width="14%"><div>작성자</div></th>
        <th width="17%"><div>날짜</div></th>
        <th width="11%"><div>조회수</div></th>
      </tr>
         <c:set var="num" value="${listcount-(page-1) * 10}"/>                                                                                                                                                                                               
    <c:forEach var="b" items="${boardlist}">
    <tr>
      <td>
        <c:out value="${num}"/>  <%-- num 출력 —--%>
        <c:set var="num" value="${num-1}"/>  <%-- num = num - 1 --%>
      </td>
      <td>
        <div>      
          <a href="./NTBoardDetailAction.nt?num=${b.ntnum}">${b.ntsub}</a>
        </div>
      </td>
      <td>
        <div>${b.aname}</div>
      </td>
      <td>
        <div>${b.ntdate}</div>
      </td>
      <td>
        <div>${b.ntvisit}</div>
      </td>
    </tr>
    </c:forEach>
    
    <c:if test="${listcount == 0}">
      <tr>
        <td colspan="3">공지 게시판</td>
        <td style="text-align: right">
          <font size=2>등록된 글이 없습니다.</font>
        </td>
      </tr>
    </c:if>         
          
    <tr class="h30 lime center btn"  style="color:#6799FF;">
      <td colspan=5 style="text-align: center">
        <c:if test="${page <= 1}">
          이전&nbsp;
        </c:if> 
        <c:if test="${page > 1}">
          <a href="./NTBoardList.nt?page=${page-1}" class="pageBefore">이전</a>
        </c:if> 
        <c:forEach var="a" begin="${startpage}" end="${endpage}">
          <c:if test="${a == page}">
            ${a}
          </c:if>
          <c:if test="${a != page}">
          <a href="./NTBoardList.nt?page=${a}" class="pageCurrent">${a}</a>
          </c:if>
         </c:forEach> 
        <c:if test="${page >= maxpage}">
          &nbsp;다음
        </c:if> 
        <c:if test="${page < maxpage}">
        <a href="./NTBoardList.nt?page=${page + 1}" class="pageAfter">&nbsp;다음</a>
        </c:if>
      </td>
    </tr>
  </table>
  		<form action="NTBoardWrite.nt" method="get" style="height:28px;">
		<br>
		<br>
		<c:if test="${sessionScope.id == 'admin'}">
  <center><input type="submit" id="button" value="글쓰기" style="border: 1px; border-radius: 8px; width: 200px;"></center>
  </c:if>
</form>
    <script type="text/javascript">
    
    
    
    ////////////////////////////검색 Ajax 처리 
    
    /**
   	* 1. 현재 검색에 대한 테이블의 생성 및 삭제는 java에서 처리하도록 설정
   	* 
    * -------------- any ways ---------------------------- 
    *       
    		
    *   (1) 현재 처리된 방법
    	(2) sucess한 data를 read한 후 다시 해당 페이지로 forward 처리함. - (좋지않음)
    *   (3) Controlle                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           r에서 JSON Object를 생성하고  boardlist와 같은 데이터를 key & value로 설정합니다. ajax에서 json data를 받아오는데 성공하면 테이블을 동적으로 지우고 생성합니다.
    */
    
    
    
    
    $(document).ready(function(){
  		
		$('[name="search"]').click(function() {
		  	var text = $('[name="condition"]').val().trim();
			var opt =  $("#select option:selected").val();
		    var page = 1;
			
			if(text=="" ){
				alert('검색어를 넣어주세요.');
			}else if(opt == "선택"){
				alert('옵션을 선택해주세요.');
			}else{
				$.ajax({
				    type : "GET",
				    data : {  "opt":opt,
				    		 "condition":text,
				    		 "page":page,
				    		 "search":true
				    		},
				 /*    url : "./NTBoardList.nt", */
				    url : "./NTBoardList.nt",
				    cache: false, 
				    headers : {"cache-control" : "no-cache", 
				    	       "pragma" : "no-cache"},
				    	       
				    success : function(data){
				    	if(data!=null){
				    		$('.list tr:not(:first)').remove();
				    		$('.list').append(data);
				    	}
				    	
				    },
				    error : function(){
				     alert("에러");
				    }
				   })//ajax end		
			}
		});
		
		
		
		
    });
    </script>

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
<br>
<%@ include file="../../footer/Footer.jsp" %>
</body>
</html>