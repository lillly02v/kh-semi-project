<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script src="./js/jquery-3.3.1.js"></script>
<script>
	$(document).ready(function(){
		$("#btn1").click(function(){
			$("#output").append("<tr><td>추가</td></tr>");
			
		});
		
		function selectData(){
			var data = $('#insert_form').serialize();
			$.getJSON("products5.WB", data, function(rdata){
				$(rdata).each(function(index, item){
					
					var output = '';
					output += '<tr>';
					output += '<td>' + item.wrnum + '</td>';
					output += '<td>' + item.wwbnum + '</td>';
					output += '<td>' + item.usid + '</td>';
					output += '<td>' + item.wrcont + '</td>';
					output += '<td>' + item.wrdate + '</td>';
					output += '<td>' + item.wrsecret + '</td>';
					output += '</tr>';
					$("#output").append(output);
					
					
				});
			});
		}
		
		$('#insert_form').submit(function(event){
			selectData();
			event.preventDefault();
		});

	});
</script>
</head>
<body>
<div>

<button style="background:#5D5D5D; color:white; border:0; height:28px; line-height: 28px;" id="btn1">댓글보기</button>
		<table border="1" id="treeData">
		</table>
	</div>
<div>
		<table border="1" id="output">
		</table>
	</div>
	<div>
		<form id="insert_form">
		<c:set var="bd" value="${boardDetail}"/>
			<fieldset>
				<legend>댓글등록</legend>	
				<table>
				
					<tr>
						<td><label>아이디 입력</label></td>
						<td><input type="hidden" name="wwbnum" id="wwbnum" value="${bd.wbnum}">
						<input type="text" name="usid" id="usid"></td>
					</tr>
					<tr>
						
						<td><select  name="wrsecret" id="wrsecret">
						<option value="show">공개글</option>
						<option value="hide">비밀글</option>
						
						</select></td>
						<td><textarea style="width:300px;height:150px;" name="wrcont" id="wrcont"></textarea></td>
					</tr>
					<tr>
						<td colspan="2"><input style="background:#5D5D5D; color:white; border:0; height:28px; line-height: 28px;" type="submit" value="댓글등록"></td>
					</tr>
					
				</table>
			</fieldset>
		</form>
	</div>
	
	
</body>
</html>