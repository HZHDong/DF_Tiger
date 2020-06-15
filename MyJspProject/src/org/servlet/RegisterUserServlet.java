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
public class RegisterUserServlet extends HttpServlet {

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
		
		// �ӿ� x = new ʵ����();
		IMyUserService userService = new MyUserServiceImpl();
		boolean result = userService.addMyUser(user);

		// ������Ӧ����
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");

		if (result) {// ע��ɹ�
			//�˴����½�session��ֻ��ȥȡ�Ѿ�������session
			HttpSession session = request.getSession(false);
			session.setAttribute("id", id);
			request.getRequestDispatcher("QueryMyUserByIdServlet").forward(request, response);
		} else {// ע��ʧ��
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('�û��Ѵ��ڣ�ע��ʧ�ܣ�����'); window.location='register.jsp' </script>");
			out.flush();
			out.close();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
