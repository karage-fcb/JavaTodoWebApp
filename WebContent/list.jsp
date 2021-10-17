<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List, java.util.ArrayList,model.dao.dto.TodoDTO"%>
<%@ page import="constant.Parameters" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file='base.html' %>
<title>Todo List</title>
</head>
<body>
	<%
		List<TodoDTO> todoList = (List) request.getAttribute("todoList");
	%>
	<div class='container'>
		<h3>Todo 一覧</h3>
		<%
			for (TodoDTO todo : todoList) {
		%>
		<div>
			<div>
				<hr>
				<h5><%=todo.getTodo()%></h5>
				<h6><%=todo.getTimeLimit()%></h6>
				<a href="update-servlet?<%=Parameters.TODO_ID %>=<%= todo.getId() %>">todoを更新する</a>
				<a href="delete-servlet?<%=Parameters.TODO_ID %>=<%= todo.getId() %>">todoを削除する</a>
				<br>
			</div>
		</div>
		<%
			}
		%>
		<hr>
		<form action="insert-servlet" method="post">
			<label>Todo: </label><input type="text" name="<%=Parameters.TODO %>"><br>
			<label>Limit: </label><input type="date" name="<%=Parameters.TIME_LIMIT %>"> <br>
			<input type="submit" value="Todoを登録する">
		</form>

	</div>
	<script type="text/javascript" src="js/script.js"></script>
</body>
</html>