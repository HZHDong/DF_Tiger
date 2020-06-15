package org.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.entity.Myuser;
import org.service.IMyUserService;
import org.service.impl.MyUserServiceImpl;

@SuppressWarnings("serial")
public class UpdateUserServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		int age = Integer.valueOf(request.getParameter("age"));
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		
		Myuser user = new Myuser(id,name,pwd,age,phone,address,city);
		
		// 接口 x = new 实现类();
		IMyUserService userService = new MyUserServiceImpl();
		boolean result = userService.updateMyUser(user);

		// 设置响应编码
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		if (result) {// 更新成功
			out.print("<script>alert('更新成功！！！'); </script>");
			//此处不新建session，只是去取已经创建的session
			HttpSession session = request.getSession(false);
			session.setAttribute("id", id);
			request.getRequestDispatcher("QueryMyUserByIdServlet").forward(request, response);
		} else {// 更新失败
			out.print("<script>alert('更新失败！！！'); </script>");
			//此处不新建session，只是去取已经创建的session
			HttpSession session = request.getSession(false);
			session.setAttribute("id", id);
			request.getRequestDispatcher("QueryMyUserByIdServlet").forward(request, response);
		}
		
		out.flush();
		out.close();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
