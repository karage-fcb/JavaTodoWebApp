<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.dao.dto.TodoDTO" %>
<%@ page import="constant.Parameters" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
TodoDTO todo = (TodoDTO)request.getAttribute("todo");
%>
<body>
<form action="update-servlet" method="post" >
	<label>Todo: </label><input type="text" name="<%=Parameters.TODO %>" value="<%=todo.getTodo()%>"><br>
	<label>Limit: </label><input type="date" name="<%=Parameters.TIME_LIMIT %>" value="<%=todo.getTimeLimit()%>"> <br>
	<input type="hidden" name="<%=Parameters.TODO_ID %>" value="<%=todo.getId() %>">
	<input type="submit" value="Todoを更新する">
</form>

</body>
</html>