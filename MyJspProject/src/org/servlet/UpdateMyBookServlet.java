package org.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.entity.MyBook;
import org.service.IMyBookService;
import org.service.impl.MyBookServiceImpl;

/**
 * Servlet implementation class UpdateMyBookServlet
 */
@WebServlet("/UpdateMyBookServlet")
public class UpdateMyBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMyBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String bid = request.getParameter("bid");
		String bname = request.getParameter("bname");
		String editor = request.getParameter("editor");
		int number = Integer.valueOf(request.getParameter("number"));
		int price = Integer.valueOf(request.getParameter("price"));
		
		MyBook book = new MyBook(bid,bname,editor,number,price);
		
		// 接口 x = new 实现类();
		IMyBookService bookService = new MyBookServiceImpl();
		bookService.UpdateMyBook(book);

		// 设置响应编码
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		request.getRequestDispatcher("QueryMyBooksServlet").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
