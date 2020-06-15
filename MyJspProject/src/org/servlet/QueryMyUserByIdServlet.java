package org.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.entity.Myuser;
import org.service.IMyUserService;
import org.service.impl.MyUserServiceImpl;

@SuppressWarnings("serial")
public class QueryMyUserByIdServlet extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		if(id==null)
			id=(String) request.getAttribute("id");

		//接口 x = new 实现类();
		IMyUserService userService = new MyUserServiceImpl();
		Myuser user = userService.QueryMyUserById(id) ;

		//设置响应编码
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		
		if(user==null) {//查询失败
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('用户不存在，查询失败！！！'); window.location='index.jsp' </script>");
			out.flush();
			out.close();
		}else {//查询成功
			request.setAttribute("user", user);
			request.getRequestDispatcher("userInfo.jsp").forward(request, response);  
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
