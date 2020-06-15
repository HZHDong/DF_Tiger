<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/UserInfo.css" type="text/css"/>
<title>BOOKSHOPINFO</title>
</head>
<body>
<a href="QueryMyBooksServlet?id=<%=(String)session.getAttribute("id")%>">返回</a>
	<a href="index.jsp?id=<%=(String)session.getAttribute("id")%>">首页</a>
	<div class="login-form">
        <div class="head-info">
            <label class="lbl-1"> </label>
            <label class="lbl-2"> </label>
            <label class="lbl-3"> </label>
        </div>
        <form method="post" action="AddMyBookServlet">
        	<input type="text" placeholder="User ID..." name="bid" /><br/>
			<input type="text" placeholder="Name..." name="bname"  /><br/>
			<input type="text" placeholder="Editor..." name="editor" /><br/>
			<input type="text" placeholder="Number..." name="number"  /><br/>
			<input type="text" placeholder="Price..." name="price"  /><br/>
            <input type="submit" value="确 &nbsp; 定"/>
        </form>
    </div>	
</body>
</html>