<%@page import="org.entity.MyBook"%>
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
	<%
		MyBook book = (MyBook)request.getAttribute("book");
	%>
	<div class="login-form">
        <div class="head-info">
            <label class="lbl-1"> </label>
            <label class="lbl-2"> </label>
            <label class="lbl-3"> </label>
        </div>
        <form method="post" action="UpdateMyBookServlet">
        	<input type="text" placeholder="User ID..." name="bid" value="<%=book.getId() %>" readonly="readonly"/><br/>
			<input type="text" placeholder="Name..." name="bname"  value="<%=book.getName() %>" /><br/>
			<input type="text" placeholder="Editor..." name="editor"  value="<%=book.getEditor() %>" /><br/>
			<input type="text" placeholder="Number..." name="number"  value="<%=book.getNumber() %>" /><br/>
			<input type="text" placeholder="Price..." name="price"  value="<%=book.getPrice() %>" /><br/>
            <input type="submit" value="确 &nbsp; 定"/>
        </form>
    </div>	
</body>
</html>