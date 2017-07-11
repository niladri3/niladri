package jdbcdemo;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteData
 */
@WebServlet("/DeleteData")
public class DeleteData extends HttpServlet {
	private static final long serialVersionUID = 1L;
    String para=" ";
    String para1=" ";
    String storage=" ";
    String parameter=" ";
    String sql2=" ";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteData() {
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		para=request.getParameter("value");
		para1=request.getParameter("value1");
		System.out.println(para);
		System.out.println(para1);
		
		/*if(para!="null"){
			parameter=para;
			storage="system";
		}
		else{
			parameter=para1; 
			storage="nonprodsystem";
		}*/
		
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			java.sql.Connection myconn=DriverManager.getConnection("jdbc:mysql://localhost:3306/userlogin","root","root");
			Statement myStmt=myconn.createStatement();
			if(para!=null){
				parameter=para;
				int convertID=Integer.parseInt(parameter);
				sql2="delete from system where idsystem= '"+convertID+"'";
			}
			else{
				parameter=para1; 
				int convertID=Integer.parseInt(parameter);
				sql2="delete from nonprodsystem where idsystem= '"+convertID+"'";
			}
			//String sql1="delete from 'userlogin'.'"+DataBase+"' where idsystem= '"+convertID+"'";
			//String sql="insert into `userlogin`.`"+systemTest+"`"+"(`Host`, `SID`, `SCS`, `Type`, `URL`, `SAP Components`)values('"+uhost+"','"+usid+"','"+uscs+"','"+utype+"','"+uurl+"','"+uscomps+"')";
			myStmt.executeUpdate(sql2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}
}
