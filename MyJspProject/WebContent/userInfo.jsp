<%@page import="org.entity.Myuser"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/UserInfo.css" type="text/css"/>
<title>USERINFO</title>
</head>
<body>
	<a href='./cancellation.jsp'>退出</a>
	<a href="index.jsp?id=<%=(String)session.getAttribute("id")%>">首页</a>
	<%
		Myuser user = (Myuser)request.getAttribute("user");
	%>
	<div class="login-form">
        <div class="head-info">
            <label class="lbl-1"> </label>
            <label class="lbl-2"> </label>
            <label class="lbl-3"> </label>
        </div>
        <form method="post" action="UpdateUserServlet">
        	<input type="text" placeholder="User ID..." name="id" value="<%=user.getId() %>" readonly="readonly"/><br/>
			<input type="password" placeholder="PassWorld..." name="pwd"  value="<%=user.getPsw() %>" /><br/>
			<input type="text" placeholder="Name..." name="name"  value="<%=user.getName() %>" /><br/>
			<input type="text" placeholder="Age..." name="age"  value="<%=user.getAge() %>" /><br/>
			<input type="text" placeholder="Phone..." name="phone"  value="<%=user.getPhone() %>" /><br/>
			<input type="text" placeholder="Address..." name="address"  value="<%=user.getAddress() %>" /><br/>
			<input type="text" placeholder="City..." name="city"  value="<%=user.getCity() %>" /><br/>
            <input type="submit" value="更 &nbsp; 新"/>
        </form>
    </div>
</body>
</html>