<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="table.css">
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('#Delete').click(function(){
		var value=prompt("Please Enter a number to delete","ex-1");
		$.ajax({
			
			type:'POST',
			 data:{value:value},
			 url:'DeleteData',
			 success:function(result){
				 window.location.reload(true);
			
		}
		
	});
});	
});
</script>


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
		<font><strong>Production System</strong></font>
	</h2>

	<input type="submit" id="prod" value="Production"
		onclick="location.href='http://localhost:8085/jdbcdemo/Links.jsp'">
	<input type="submit" id="nonprod" value="Non-Production"
		onclick="location.href='http://localhost:8085/jdbcdemo/NonProdLink.jsp'">

	<table align="center" cellpadding="5" cellspacing="5" border="1"
		style="width: 100%; border-collapse: collapse;">
		<tr bgcolor="#A52A2A">
			<th>ID</th>
			<th>Host</th>
			<th>SID</th>
			<th>SCS</th>
			<th>Type</th>
			<th>URL</th>
			<th>SAP Components</th>
		</tr>
		<%
try{
java.sql.Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/userlogin","root","root");
statement=connection.createStatement();
String sql="Select * from system";
resultset =  statement.executeQuery(sql);
while(resultset.next()){
%>

		<tr bgcolor="#DEB887">
			<td><%=resultset.getString("idsystem") %></td>
			<td><%=resultset.getString("Host") %></td>
			<td><%=resultset.getString("SID") %></td>
			<td><%=resultset.getString("SCS") %></td>
			<td><%=resultset.getString("Type") %></td>
			<td><a href='<%=resultset.getString("URL") %>'><%=resultset.getString("URL") %></a></td>
			<td><%=resultset.getString("SAP Components") %></td>
		</tr>
		<%
}
}catch(Exception e){
	e.printStackTrace();
}
%>
	</table>

	<form action="Adding.jsp">
		<input type="submit" value="Add" id="add">

	</form>
	<input type="submit" id="Delete" value="Delete">

</body>
</html>