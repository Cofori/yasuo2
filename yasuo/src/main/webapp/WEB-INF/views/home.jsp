<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<script
  src="https://code.jquery.com/jquery-2.2.4.js"></script>
<script>
$(function(){
	console.log( "ready!" );
	$("#insertBtn").on("click", function(){
		var nm = $(this).parent().parent().find(".nm").val();
		var todoList = $(this).parent().parent().find(".todoList").val();
	
		$("#nm").val(nm);
		$("#todoList").val(todoList);
		
		document.getElementById('form').action="insert";
		document.getElementById('form').method="POST";
		document.getElementById('form').submit();
	})
	$(".updateBtn").on("click", function(){
		var nm = $(this).parent().parent().find(".nm").val();
		var todoList = $(this).parent().parent().find(".todoList").val();
	
		$("#nm").val(nm);
		$("#todoList").val(todoList);
		
		document.getElementById('form').action="update";
		document.getElementById('form').method="POST";
		document.getElementById('form').submit();
	})
	$(".deleteBtn").on("click", function(){
		var nm = $(this).parent().parent().find(".nm").val();
		var todoList = $(this).parent().parent().find(".todoList").val();
	
		$("#nm").val(nm);
		$("#todoList").val(todoList);
		
		document.getElementById('form').action="delete";
		document.getElementById('form').method="POST";
		document.getElementById('form').submit();
	})
})
</script>
</head>
<body>
	<h1>Hello world!</h1>

	<P>The time on the server is ${serverTime}.</P>

	<table>
		<thead>
			<tr>
				<th>Number</th>
				<th>TODO</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="val" items="${data}">
				<tr>
					<td><input type="text" class="nm" value="${val.nm}"/></td>
					<td><input type="text" class="todoList" value="${val.todoList}"/></td>
					<td><input type="button" class="updateBtn" value="수정" /><input type="button" class="deleteBtn" value="삭제" /></td>
				</tr>
			</c:forEach>
			<tr>
				<td><input type="text" class="nm" /></td>
				<td><input type="text" class="todoList" /></td>
				<td><input type="button" id="insertBtn" value="등록" /></td>
			</tr>
		</tbody>
	</table>
	<form id="form">
		<input type="hidden" name="nm" id="nm" />
		<input type="hidden" name="todoList" id="todoList" />
	</form>
</body>
</html>
