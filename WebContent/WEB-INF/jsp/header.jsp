<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="constant.SessionInfo" %>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<link rel="stylesheet" href="css/base.css">
</head>
<body>
<nav class="navbar fixed-top navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="list-servlet">Todo アプリ</a>
    <span class="navbar-text">
    	<%=session.getAttribute(SessionInfo.LOGIN_USER_ID) %>
	    <a href="LogoutServlet">ログアウト</a>
    </span>
  </div>
</nav>
<div style="height: 90px;"></div>
</body>
</html>