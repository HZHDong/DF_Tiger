package org.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.entity.MyCart;
import org.service.impl.MyCartServiceImpl;

/**
 * Servlet implementation class QueryMyCartsServlet
 */
@WebServlet("/QueryMyCartsServlet")
public class QueryMyCartsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryMyCartsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		MyCartServiceImpl service  = new MyCartServiceImpl();
		List<MyCart> carts = service.QueryAllMyCarts();
		
		//设置响应编码
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		request.setAttribute("carts", carts);
		//因为request域中有数据，因此需要通过请求转发的方式跳转 （重定向会丢失request域）
		//pageContext<request<session<application;
		request.getRequestDispatcher("carts.jsp").forward(request, response);  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
