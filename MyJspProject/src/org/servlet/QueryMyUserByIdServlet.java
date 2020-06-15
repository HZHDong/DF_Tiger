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

		//�ӿ� x = new ʵ����();
		IMyUserService userService = new MyUserServiceImpl();
		Myuser user = userService.QueryMyUserById(id) ;

		//������Ӧ����
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		
		if(user==null) {//��ѯʧ��
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('�û������ڣ���ѯʧ�ܣ�����'); window.location='index.jsp' </script>");
			out.flush();
			out.close();
		}else {//��ѯ�ɹ�
			request.setAttribute("user", user);
			request.getRequestDispatcher("userInfo.jsp").forward(request, response);  
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
