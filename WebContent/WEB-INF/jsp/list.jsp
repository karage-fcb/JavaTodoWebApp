<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List, java.util.ArrayList,model.dao.dto.TodoDTO"%>
<%@ page import="constant.Parameters" %>
<%@ page import="model.viewModel.ListViewModel" %>
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
		ListViewModel model = (ListViewModel) request.getAttribute("viewModel");
	%>
	<div class='container'>
		<h3>Todo 一覧</h3>
		<%
			for (TodoDTO todo : model.getTodoList()) {
		%>
		<div>
			<div>
				<hr>
				<h4><%=todo.getUserId() %></h4>
				<h5><%=todo.getTodo()%></h5>
				<h6>期限：<%=todo.getTimeLimit()%></h6>
				<% if (model.getLoginUserId().equals(todo.getUserId())) { %>
					<a href="update-servlet?<%=Parameters.TODO_ID %>=<%= todo.getId() %>">todoを更新する</a>
					<a href="delete-servlet?<%=Parameters.TODO_ID %>=<%= todo.getId() %>">todoを削除する</a>
				<%} %>
				<br>
			</div>
		</div>
		<%
			}
		%>
		<hr>
		<h3>Todoの新規登録</h3>
		<form id="todoCreateForm" action="insert-servlet" method="post">
			<div class="form-floating">
			  <textarea id="todoContent" class="form-control" name="<%=Parameters.TODO %>" placeholder="Leave a comment here" id="floatingTextarea2" style="height: 100px"></textarea>
			  <label for="floatingTextarea2">Todo</label>
			</div>
			<label>Limit: </label><input id="todoTimeLimit" type="date" name="<%=Parameters.TIME_LIMIT %>"> <br>
			<input id="submitButton" type="button" value="Todoを登録する">
		</form>

	</div>
	<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
	<script type="text/javascript" src="js/script.js"></script>
</body>
</html>