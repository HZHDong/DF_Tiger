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

		//接口 x = new 实现类();
		IMyBookService bookService = new MyBookServiceImpl();
		MyBook book = bookService.QueryMyBookById(bid) ;

		//设置响应编码
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		
		if(book==null) {//查询失败
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('图书不存在，查询失败！！！'); window.location='shop.jsp' </script>");
			out.flush();
			out.close();
		}else {//查询成功
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
