<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%@page import="java.sql.DriverManager"%>
	<%@page import="java.sql.ResultSet"%>
	<%@page import="java.sql.Statement"%>
	<%@page import="java.sql.Connection"%>

	<%
String driverName = "com.mysql.jdbc.Driver";


try {
Class.forName(driverName);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Statement statement = null;
ResultSet resultset = null;
%>
	<h2 align="center">
		<font><strong>Retrieve data from database in jsp</strong></font>
	</h2>
	<table align="center" cellpadding="5" cellspacing="5" border="1">
		<tr>
		</tr>

		<tr bgcolor="#A52A2A">
			<td><b>id</b></td>
			<td><b>username</b></td>
			<td><b>Password</b></td>
			<td><b>Email</b></td>
		</tr>
		<%
try{
	java.sql.Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/userlogin","root","root");
	statement=connection.createStatement();
	String sql="Select * from user";
	resultset =  statement.executeQuery(sql);
	while(resultset.next()){
	%>
		<tr bgcolor="#DEB887">
			<td><%=resultset.getString("id") %></td>
			<td><%=resultset.getString("username") %></td>
			<td><%=resultset.getString("passwd") %></td>
			<td><%=resultset.getString("email") %></td>
		</tr>
		<% 
	}	
	
	}catch(Exception e){
		e.printStackTrace();
	}
%>
	</table>

</body>
</html>