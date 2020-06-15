<%@page import="org.entity.MyCart"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css" type="text/css" />
<title>CART</title>
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
				<th>图书数量</th>
				<th>图书价格</th>
				<th>━</th>
				<th>✚</th>
			</tr>
			
			<%
				//获取request域中的数据
				List<MyCart> carts = (List<MyCart> )request.getAttribute("carts") ;
				int sum = 0;
				for(MyCart cart:carts){
			%>
					<tr>
						<td><%=cart.getBid() %></td>	
						<td><%=cart.getBname() %></td>
						<td><%=cart.getBnumber() %></td>
						<td><%=cart.getBprice() %></td>	
						<td><a href="DeleteMyCartByBidServlet?id=<%=cart.getId()%>&bid=<%=cart.getBid() %>">━</a></td>
						<td><a href="AddMyCartByBidServlet2?id=<%=cart.getId()%>&bid=<%=cart.getBid() %>">✚</a></td>	
					</tr>
			<%
					sum += (cart.getBnumber()*cart.getBprice());
				}
			%>
			<tfoot>
				<td>购物总计金额： &nbsp; <%=sum %></td>
				<td><a href="#">确定</a></td>
			</tfoot>
		
		</table>
    
</body>
</html>