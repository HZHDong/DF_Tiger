package org.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.entity.MyCart;
import org.service.impl.MyCartServiceImpl;

/**
 * Servlet implementation class QueryMyCartByIdServlet
 */
@WebServlet("/QueryMyCartByIdServlet")
public class QueryMyCartByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryMyCartByIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		if("000".equals(id))
			request.getRequestDispatcher("QueryMyCartsServlet").forward(request, response);
		MyCartServiceImpl service  = new MyCartServiceImpl();
		List<MyCart> carts = service.QueryAllMyCarts(id);
		
		//������Ӧ����
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
				
		if(carts==null) {//��ѯʧ��
			PrintWriter out = response.getWriter();
			out.print("<script>alert('�û������ڣ���ѯʧ�ܣ�����'); window.location='index.jsp' </script>");
			out.flush();
			out.close();
		}else {//��ѯ�ɹ�
			request.setAttribute("carts", carts);
			//��Ϊrequest���������ݣ������Ҫͨ������ת���ķ�ʽ��ת ���ض���ᶪʧrequest��
			//pageContext<request<session<application;
			request.getRequestDispatcher("cart.jsp").forward(request, response);  
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
