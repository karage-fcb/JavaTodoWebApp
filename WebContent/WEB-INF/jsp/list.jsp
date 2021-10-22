<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List, java.util.ArrayList,model.dao.dto.TodoDTO"%>
<%@ page import="constant.Parameters" %>
<%@ page import="model.viewModel.ListViewModel" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file='header.jsp' %>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/list.css">
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
					<button onclick="updateTodo(<%=todo.getId() %>);" type="button" class="btn btn-info">Info</button>
					<button onclick="deleteTodo(<%=todo.getId() %>);" type="button" class="btn btn-danger">todoを削除する</button>
					<a href="delete-servlet?<%=Parameters.TODO_ID %>=<%= todo.getId() %>"></a>
				<%} %>
				<br>
			</div>
		</div>
		<%
			}
		%>
		<hr>
		<!-- Button trigger modal -->
		<button type="button" class="btn btn-warning" data-bs-toggle="modal" data-bs-target="#exampleModal">
		Todoを登録する
		</button>

		<!-- 新規登録Modal -->
		<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
			<div class="modal-content">
			  <div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Todoを新規登録する</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			  </div>
			  <div class="modal-body">
				<form id="todoCreateForm" action="insert-servlet" method="post">
					<div class="form-floating">
					  <textarea id="todoContent" class="form-control" name="<%=Parameters.TODO %>" placeholder="Leave a comment here" id="floatingTextarea2" style="height: 100px"></textarea>
					  <label for="floatingTextarea2">Todo</label>
					</div>
					<label>Limit: </label><input id="todoTimeLimit" type="date" name="<%=Parameters.TIME_LIMIT %>"> <br>
					<!-- <input id="submitButton" type="button" value="Todoを登録する"> -->
				</form>
			  </div>
			  <div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
				<button id="submitButton" type="button" class="btn btn-warning">登録する</button>
			  </div>
			</div>
		  </div>
		</div>
	</div>
	<script type="text/javascript" src="js/script.js"></script>
</body>
</html>