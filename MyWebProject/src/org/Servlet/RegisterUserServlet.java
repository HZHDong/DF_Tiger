package org.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.Service.UserService;
import org.entity.User;

/**
 * Servlet implementation class RegisterUserServlet
 */
@WebServlet("/RegisterUserServlet")
public class RegisterUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name_first = request.getParameter("name_first");
		String name_second = request.getParameter("name_second");
		String email = request.getParameter("email");
		
		User user = new User(id,pwd,name_first,name_second,email);
		System.out.println(user.toString());
		// 接口 x = new 实现类();
		UserService userService = new UserService();
		boolean result = userService.AddUser(user);

		// 设置响应编码
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");

		if (result) {// 注册成功
			HttpSession session = request.getSession(true);
			session.setAttribute("id", id);
			session.setAttribute("name_first", name_first);
			session.setAttribute("name_second", name_second);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {// 注册失败
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('用户已存在，注册失败！！！'); window.location='sign-up.html' </script>");
			out.flush();
			out.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
