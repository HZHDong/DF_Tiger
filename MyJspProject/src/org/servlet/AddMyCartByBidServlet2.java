package org.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.entity.MyBook;
import org.entity.MyCart;
import org.service.impl.MyBookServiceImpl;
import org.service.impl.MyCartServiceImpl;

/**
 * Servlet implementation class AddMyCartByBidServlet2
 */
@WebServlet("/AddMyCartByBidServlet2")
public class AddMyCartByBidServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMyCartByBidServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//设置响应编码
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		if(id==null) {//没有登录
			PrintWriter out = response.getWriter();
			out.print("<script>alert('请先登录！！！'); window.location='login.jsp' </script>");
			out.flush();
			out.close();
		}
		String bid = request.getParameter("bid");
		
		MyCartServiceImpl cartservice  = new MyCartServiceImpl();
		boolean isexit = cartservice.isEixtMyCart(id,bid);
		boolean rs = false;
		if(isexit==true) {
			MyCart cart = cartservice.QueryMyCartById(id, bid);
			cart.setBnumber(cart.getBnumber()+1);
			rs = cartservice.UpdateMyCartNumber(cart);
		}else {
			MyBookServiceImpl bookservice = new MyBookServiceImpl();
			MyBook book = bookservice.QueryMyBookById(bid);
			MyCart cart = new MyCart(id,book.getId(),book.getName(),1,book.getPrice());
			rs = cartservice.AddMyCart(cart);
		}
				
		if(rs==false) {//查询失败
			PrintWriter out = response.getWriter();
			out.print("<script>alert('添加失败！！！'); window.location='index.jsp' </script>");
			out.flush();
			out.close();
		}else {//查询成功
			request.getRequestDispatcher("QueryMyCartByIdServlet").forward(request, response);  
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
