<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/Login.css" type="text/css"/>
<title>LOGIN</title>
</head>
<body>
<a href="index.jsp?id=<%=(String)session.getAttribute("id")%>">首页</a>
		<div class="login-form">
        <div class="head-info">
            <label class="lbl-1"> </label>
            <label class="lbl-2"> </label>
            <label class="lbl-3"> </label>
        </div>
        <form method="post" action="LoginServlet">
            <input type="text" placeholder="User ID..." name="id" />
            <input type="password" placeholder="PassWorld..." name="pwd" />
            <input type="submit" value="登 &nbsp; 录"/>
        </form>
        <div>
            <a href="register.jsp" class="link">注 &nbsp; 册</a>
        </div>
    </div>
</body>
</html>