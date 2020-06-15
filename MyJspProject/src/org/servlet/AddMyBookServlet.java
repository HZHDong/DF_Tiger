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
 * Servlet implementation class AddMyBookServlet
 */
@WebServlet("/AddMyBookServlet")
public class AddMyBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMyBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bid = request.getParameter("bid");
		String bname = request.getParameter("bname");
		String editor = request.getParameter("editor");
		int number = Integer.valueOf(request.getParameter("number"));
		int price = Integer.valueOf(request.getParameter("price"));
		
		MyBook book = new MyBook(bid,bname,editor,number,price);
		
		// �ӿ� x = new ʵ����();
		IMyBookService bookService = new MyBookServiceImpl();
		bookService.AddMyBook(book);

		// ������Ӧ����
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
