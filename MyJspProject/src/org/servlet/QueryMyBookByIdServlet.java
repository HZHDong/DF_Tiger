package org.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.entity.MyBook;
import org.service.IMyBookService;
import org.service.impl.MyBookServiceImpl;

/**
 * Servlet implementation class QueryMyBookByIdServlet
 */
@WebServlet("/QueryMyBookByIdServlet")
public class QueryMyBookByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryMyBookByIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String bid = request.getParameter("bid");

		//�ӿ� x = new ʵ����();
		IMyBookService bookService = new MyBookServiceImpl();
		MyBook book = bookService.QueryMyBookById(bid) ;

		//������Ӧ����
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		
		if(book==null) {//��ѯʧ��
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('ͼ�鲻���ڣ���ѯʧ�ܣ�����'); window.location='shop.jsp' </script>");
			out.flush();
			out.close();
		}else {//��ѯ�ɹ�
			request.setAttribute("book", book);
			System.out.println(id);
			if("000".equals(id))
				request.getRequestDispatcher("bookShopInfo.jsp").forward(request, response);
			else
				request.getRequestDispatcher("bookInfo.jsp").forward(request, response);  
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
