<%@page import="org.entity.MyCart"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css" type="text/css" />
<title>CARTS</title>
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
				<th>用户名</th>
				<th>书号</th>
				<th>书名</th>
				<th>图书数量</th>
				<th>图书价格</th>
				<th>订单价</th>
			</tr>
			
			<%
				//获取request域中的数据
				List<MyCart> carts = (List<MyCart> )request.getAttribute("carts") ;
				String id = carts.get(0).getId();
				for(int i=0;i<carts.size();i++){
					MyCart cart = carts.get(i);
					if(cart.getId().equals(id)){
						int sum = 0;
			%>
					<tr>
						<td><%=cart.getId() %></td>	
					</tr>
			<%
						while(cart.getId().equals(id)){
			%>
						<tr>
							<td></td>
							<td><%=cart.getBid() %></td>	
							<td><%=cart.getBname() %></td>
							<td><%=cart.getBnumber() %></td>
							<td><%=cart.getBprice() %></td>	
						</tr>
			<%
							sum += (cart.getBnumber()*cart.getBprice());
							if(i+1<carts.size()){
								i++;
								cart = carts.get(i);
							}else
								break;
						}
			%>
						<tr>
							<td></td>	
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td><%=sum %></td>
						</tr>
			<%
					}
					if(i+1<carts.size())
						id = carts.get(i+1).getId();
				}
			%>
		</table>
    
</body>
</html>