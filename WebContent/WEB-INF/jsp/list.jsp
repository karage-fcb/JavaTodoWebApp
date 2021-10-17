<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List, java.util.ArrayList,model.dao.dto.TodoDTO"%>
<%@ page import="constant.Parameters" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file='header.jsp' %>
<%-- <jsp:include page="header.jsp"> --%>
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
		<h3>Todoの新規登録</h3>
		<form action="insert-servlet" method="post">
			<div class="form-floating">
			  <textarea class="form-control" name="<%=Parameters.TODO %>" placeholder="Leave a comment here" id="floatingTextarea2" style="height: 100px"></textarea>
			  <label for="floatingTextarea2">Todo</label>
			</div>
			<label>Limit: </label><input type="date" name="<%=Parameters.TIME_LIMIT %>"> <br>
			<input type="submit" value="Todoを登録する">
		</form>

	</div>
	<script type="text/javascript" src="js/script.js"></script>
</body>
</html>