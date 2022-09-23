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
		$('button').one('click', function(){
			var data = $('#insert_form').serialize();
			$.getJSON("products5.bo", data, function(rdata){
				$("#treeData").append(
					"<tr><td>vrnum</td><td>vvbnum</td><td>usid</td>"
					+"<td>vrcont</td><td>vrdate</td><td>vrsecret</td></tr>"
				);
				
				$(rdata).each(function(index, item){
					$("#treeData").append(
							"<tr>"
							+ "<td>" + this.vrnum + "</td>"
							+ "<td>" + this.vvbnum + "</td>"
							+ "<td>" + this.vid + "</td>"
							+ "<td>" + this.vrcont + "</td>"
							+ "<td>" + this.vrdate + "</td>"
							+ "<td>" + this.vrsecret + "</td></tr>");
		});
			});
		});
		
		function selectData(){
			var data = $('#insert_form').serialize();
			$.getJSON("products5.bo", data, function(rdata){
				$(rdata).each(function(index, item){
					
					var output = '';
					output += '<tr>';
					output += '<td>' + item.vrnum + '</td>';
					output += '<td>' + item.vvbnum + '</td>';
					output += '<td>' + item.usid + '</td>';
					output += '<td>' + item.vrcont + '</td>';
					output += '<td>' + item.vrdate + '</td>';
					output += '<td>' + item.vrsecret + '</td>';
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

<button>댓글보기</button>
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
						<td><input type="hidden" name="vvbnum" id="vvbnum" value="${bd.vbnum}">
						<input type="text" name="usid" id="usid"></td>
					</tr>
					<tr>
						
						<td><select  name="vrsecret" id="vrsecret">
						<option value="show">공개글</option>
						<option value="hide">비밀글</option>
						
						</select></td>
						<td><textarea style="width:300px;height:150px;" name="vrcont" id="vrcont"></textarea></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="댓글등록"></td>
					</tr>
					
				</table>
			</fieldset>
		</form>
	</div>
	
	
</body>
</html>