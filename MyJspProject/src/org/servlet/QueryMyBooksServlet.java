package org.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.entity.MyBook;
import org.service.impl.MyBookServiceImpl;

/**
 * Servlet implementation class QueryMyBooksServlet
 */
@WebServlet("/QueryMyBooksServlet")
public class QueryMyBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryMyBooksServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		MyBookServiceImpl service  = new MyBookServiceImpl();
		List<MyBook> books = service.QueryAllMyBooks();
		
		//������Ӧ����
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
				
		if(books==null) {//��ѯʧ��
			PrintWriter out = response.getWriter();
			out.print("<script>alert('�û������ڣ���ѯʧ�ܣ�����'); window.location='index.jsp' </script>");
			out.flush();
			out.close();
		}else {//��ѯ�ɹ�
			System.out.println(books);
			request.setAttribute("books", books);
			//��Ϊrequest���������ݣ������Ҫͨ������ת���ķ�ʽ��ת ���ض���ᶪʧrequest��
			//pageContext<request<session<application;
			String id = request.getParameter("id");
			if("000".equals(id))
				request.getRequestDispatcher("shoper.jsp").forward(request, response);  
			request.getRequestDispatcher("shop.jsp").forward(request, response);  
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
