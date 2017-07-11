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

@WebServlet("/addingdata")
public class addingdata extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		out.println("Welcome");
		System.out.println("Welcome");
		
		String uid=request.getParameter("uid");
		String uhost=request.getParameter("uhost");
		String usid=request.getParameter("usid");
		String uscs=request.getParameter("uscs");
		String utype=request.getParameter("utype");
		String uurl=request.getParameter("uurl");
		String uscomps=request.getParameter("uscomp");
		
		
		System.out.println(uid+","+uhost+","+utype+"");
		
		
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			java.sql.Connection myconn=DriverManager.getConnection("jdbc:mysql://localhost:3306/userlogin","root","root");
			Statement myStmt=myconn.createStatement();
			//ResultSet rs=myStmt.executeQuery("select * from system");
			//String sql="insert into user"+"(id,username,passwd,email)"+"values('2','Niladri','Niladri','Niladri')";
			//INSERT INTO `userlogin`.`system` (`idsystem`, `Host`, `SID`, `SCS`, `Type`, `URL`, `SAP Components`) VALUES ('3', 'Test3', 'Test3', 'Test3', 'Test3', 'Test3', 'Test3');
			//String sql = "insert into login (user,pass) values('" + user + "','" + pass + "')";
			String systemTest="system";
			String sql="insert into `userlogin`.`"+systemTest+"`"+"(`Host`, `SID`, `SCS`, `Type`, `URL`, `SAP Components`)values('"+uhost+"','"+usid+"','"+uscs+"','"+utype+"','"+uurl+"','"+uscomps+"')";
			myStmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		response.sendRedirect("Links.jsp");
	}

}
