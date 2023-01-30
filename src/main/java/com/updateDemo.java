package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class updateDemo
 */
public class updateDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateDemo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uid=request.getParameter("uid");
		
		String usalary =request.getParameter("usalary");
		
		
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/simpleylearn","root","root");
			PreparedStatement stmt= con.prepareStatement("update employee set salary= ? where uid= ? ");
			stmt.setString(1, usalary);
			stmt.setString(2, uid);
			
			stmt.execute();
			stmt.close();
			con.close();
			
			
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			out.print("<h3> Data UPdated  Succesufallyy</h3>");
			out.print("<a href='Main.html'>Main Page </a>");
			
		} 
		catch (Exception e) {
			System.out.println(e);
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
