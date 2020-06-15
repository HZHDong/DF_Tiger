<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CANCELLATION</title>
</head>
<body>
	<%
		String id=(String)session.getAttribute("id");
		out.println("Session ID:"+session.getId());//输出会话编号
		session.invalidate();//注销会话。
		out.print("<script>alert('再见！欢迎再来！！'); window.location='index.jsp' </script>");
	%>
	</p>
</body>
</html>