<%@page import="org.entity.MyBook"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css" type="text/css" />
<title>SHOPER</title>
</head>
<body>
<div class="top">
        <div class="logo">
            <h1><a href="index.jsp?id=<%=(String)session.getAttribute("id")%>">b<span>Books</span></a></h1>
        </div>
        <div class="right">
            <a href="login.jsp">登录</a> &nbsp; ● &nbsp; <a href="register.jsp">注册</a> &nbsp; ● &nbsp; <a href='./cancellation.jsp'>退出</a>
        </div>
    </div>
    <div class="topnav">
        <nav>
          <ul>
            <li> &nbsp;  &nbsp; </li>
            <li><a href="index.jsp?id=<%=(String)session.getAttribute("id")%>">首页</a></li>
            <li><a href="QueryMyBooksServlet?id=<%=(String)session.getAttribute("id")%>">商铺页面</a></li>
            <li><a href="QueryMyCartByIdServlet?id=<%=(String)session.getAttribute("id")%>">购物车</a></li>
            <li><a href="QueryMyUserByIdServlet?id=<%=(String)session.getAttribute("id")%>">个人信息</a></li>
          </ul>
        </nav>
    </div>

	<table>
			<tr>
				<th>书号</th>
				<th>书名</th>
				<th>作者</th>
				<th>图书数量</th>
				<th>图书价格</th>
				<th>删除图书</th>
			</tr>
			
			<%
				//获取request域中的数据
				List<MyBook> books = (List<MyBook> )request.getAttribute("books") ;
				for(MyBook book:books){
			%>
					<tr>
						<td><a href="QueryMyBookByIdServlet?id=<%=(String)session.getAttribute("id")%>&bid=<%=book.getId() %>"><%=book.getId() %></a></td>		
						<td><%=book.getName() %></td>	
						<td><%=book.getEditor() %></td>
						<td><%=book.getNumber() %></td>
						<td><%=book.getPrice() %></td>
						<td><a href="DeleteMyBookByIdServlet?id=<%=(String)session.getAttribute("id")%>&bid=<%=book.getId() %>">━</a></td>
					</tr>
			<%
				}
			%>
			<tfoot>
				<td><a href="addbookInfo.jsp">✚</a></td>
			</tfoot>
		
		</table>
    
</body>
</html>