package org.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.entity.MyCart;
import org.service.impl.MyCartServiceImpl;

/**
 * Servlet implementation class DeleteMyCartByBidServlet
 */
@WebServlet("/DeleteMyCartByBidServlet")
public class DeleteMyCartByBidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMyCartByBidServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//������Ӧ����
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		if(id==null) {//û�е�¼
			PrintWriter out = response.getWriter();
			out.print("<script>alert('���ȵ�¼������'); window.location='login.jsp' </script>");
			out.flush();
			out.close();
		}
		String bid = request.getParameter("bid");
		
		MyCartServiceImpl cartservice  = new MyCartServiceImpl();
		boolean rs = false;
		MyCart cart = cartservice.QueryMyCartById(id, bid);
		int number = cart.getBnumber();
		if(number==1) {
			rs = cartservice.DeleteMyCart(id, bid);
		}else {
			rs = cartservice.UpdateMyCartNumber(id, bid, number-1);
		}
				
		if(rs==false) {//��ѯʧ��
			PrintWriter out = response.getWriter();
			out.print("<script>alert('ɾ��ʧ�ܣ�����'); window.location='index.jsp' </script>");
			out.flush();
			out.close();
		}else {//��ѯ�ɹ�
			request.getRequestDispatcher("QueryMyCartByIdServlet").forward(request, response);  
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
