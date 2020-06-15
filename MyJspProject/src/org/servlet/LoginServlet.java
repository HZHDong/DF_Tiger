package org.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.service.IMyUserService;
import org.service.impl.MyUserServiceImpl;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		// �ӿ� x = new ʵ����();
		IMyUserService userService = new MyUserServiceImpl();
		boolean result = userService.isEixtMyUser(id, pwd);

		// ������Ӧ����
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");

		if (result) {// ��¼�ɹ�
			//�˴����½�session��ֻ��ȥȡ�Ѿ�������session
			HttpSession session = request.getSession(false);
			session.setAttribute("id", id);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {// ��¼ʧ��
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('�û�����������󣬵�¼ʧ�ܣ�����'); window.location='login.jsp' </script>");
			out.flush();
			out.close();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
