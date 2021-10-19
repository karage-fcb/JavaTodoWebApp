<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="constant.Parameters"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/login.css">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
<title>Todoアプリログイン画面</title>
</head>
<body>
	<!-- login.jspのbodyの中を以下の通り編集 -->
	<!-- リクエストスコープからエラーメッセージを受け取る -->
	<%
		String failureMessage = (String) request.getAttribute("loginFailure");
	%>

	<!-- エラーメッセージが存在するときだけ表示する -->
	<%
		if (failureMessage != null) {
	%>
	<%=failureMessage%>
	<%
		}
	%>

	<!-- ログインフォーム。ユーザーIDとパスワードの入力を行う -->
	<div class="main">
		<p class="sign" align="center">Login</p>
		<form class="form1" action="LoginServlet" method="post">
			<input name="<%=Parameters.LOGIN_ID %>" class="un " type="text" align="center" placeholder="Username">
			<input name="<%=Parameters.LOGIN_PASSWORD%>"  class="pass" type="password" align="center" placeholder="Password">
			<input type="submit" id="submit" value="ログイン" class="submit" align="center" />
		</form>
    </div>
</body>
</html>