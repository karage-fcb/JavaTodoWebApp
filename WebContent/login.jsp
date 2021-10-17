<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="constant.Parameters" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- login.jspのbodyの中を以下の通り編集 -->
<!-- リクエストスコープからエラーメッセージを受け取る -->
<%String failureMessage = (String)request.getAttribute("loginFailure"); %>

<!-- エラーメッセージが存在するときだけ表示する -->
<% if (failureMessage != null) {%>
	<%=failureMessage %>
<%} %>

<!-- ログインフォーム。ユーザーIDとパスワードの入力を行う -->
<form action="LoginServlet" method="post">
	<input type="text" name="<%=Parameters.LOGIN_ID %>">
	<input type="password" name="<%=Parameters.LOGIN_PASSWORD %>">
	<input type="submit" value="ログイン">
</form>
</body>
</html>