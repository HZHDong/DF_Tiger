<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/Register.css" type="text/css"/>
<title>REGISTER</title>
</head>
<body>
<a href='./login.jsp'>返回</a>
<a href="index.jsp?id=<%=(String)session.getAttribute("id")%>">首页</a>
		<div class="login-form">
        <div class="head-info">
            <label class="lbl-1"> </label>
            <label class="lbl-2"> </label>
            <label class="lbl-3"> </label>
        </div>
        <form method="post" action="RegisterUserServlet">
             <input type="text" placeholder="User ID..." name="id" />
            <input type="password" placeholder="PassWorld..." name="pwd" />
            <input type="text" placeholder="Name..." name="name" /><br/>
			<input type="text" placeholder="Age..." name="age" /><br/>
			<input type="text" placeholder="Phone..." name="phone" /><br/>
			<input type="text" placeholder="Address..." name="address" /><br/>
			<input type="text" placeholder="City..." name="city" /><br/>
            <input type="submit" value="确 &nbsp; 定"/>
        </form>
    </div>
</body>
</html>