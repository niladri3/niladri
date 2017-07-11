package jdbcdemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		
		
		String uname=request.getParameter("uname");
		String upass=request.getParameter("upass");
		
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			java.sql.Connection myconn=DriverManager.getConnection("jdbc:mysql://localhost:3306/userlogin","root","root");
			Statement myStmt=myconn.createStatement();
			ResultSet rs=myStmt.executeQuery("select * from user");
			while(rs.next()){
				out.println(uname);
				out.println(rs.getString("username")+"Hello");
				if((rs.getString("username").equals(uname))&& (rs.getString("passwd")).equals(upass)){
					out.println("<h1>Welcome<h1>");
				}
				else{
					out.println("<h1>fail<h1>");
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
