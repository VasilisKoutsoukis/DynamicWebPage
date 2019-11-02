<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
 <div align="center">
  <h2>Login to Platform</h2>
  <form action="<%=request.getContextPath()%>/login" method="post">
   <table style="with: 100%">
    <tr>
     <td>UserName</td>
     <td><input type="text" name="username" /></td>
    </tr>
    <tr>
     <td>Password</td>
     <td><input type="password" name="password" /></td>
    </tr>
    <tr>
    	<td> <input type="submit" value="Submit" /></td>
    </tr>
    <tr>
  		<td><a href="register.jsp">Registration</a></td>
  	</tr>
   </table>
  </form>
 </div>
</body>
</html>	