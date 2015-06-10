package com.myhouse.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.Request;

import com.myhouse.entity.User;
import com.myhouse.service.UserService;



public class RegisterServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public RegisterServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	//	response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		//System.out.println("name: "+name);
		name = new String(name.getBytes("iso-8859-1"),"utf-8");
		UserService service = new UserService();
		boolean result=service.selUserIsTrue(name);
		if(result==true){
			out.print("true");
		}else{
			out.print("false");
		}
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//response.setContentType("text/html;charset = utf-8");
		//request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String telephone = request.getParameter("telephone");
		String username = request.getParameter("username");
		User user = new User(name, password, telephone, username);
		UserService service = new UserService();
		int result = service.addUser(user);
		if (result == -1) {
			out.print("<script>alert('用户名已存在');history.go(-1);</script>");
		} else if (result == 0) {
			out.print("<script>alert('未知原因，注册失败');history.go(-1);</script>");
		} else {
			request.getRequestDispatcher("regsuccess.jsp").forward(request, response);
			//response.sendRedirect("regsuccess.jsp");
		}
		out.close();
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
		
	}

}
