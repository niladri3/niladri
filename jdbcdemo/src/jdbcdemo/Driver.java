package jdbcdemo;

import java.sql.*;
public class Driver {

	public static void main(String[] args){
		
		try{
			//get a connection to the database
			
			Connection myconn=DriverManager.getConnection("jdbc:mysql://localhost:3306/userlogin","root","root");
			//create a statement
			Statement myStmt=myconn.createStatement();
			
			//inserting data into database
			String sql="insert into user"+"(id,username,passwd,email)"+"values('2','Niladri','Niladri','Niladri')";
			myStmt.executeUpdate(sql);
			
			//delete data from a database
			String sql1="delete from user where id=2";
			myStmt.executeUpdate(sql1);
			
			//Execute sql query
			ResultSet myRs=myStmt.executeQuery("select * from user");
			
			//Process the result set
			while(myRs.next()){
				System.out.println(myRs.getString("username")+","+myRs.getString("passwd"));
			}
			
			
		}
		catch(Exception exc){
			exc.printStackTrace();
		}
	}
}
