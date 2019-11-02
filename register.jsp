<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
</head>
<body>
	<div align="center">
		<form action="<%=request.getContextPath()%>/register" method="post">
		<h2 style="color: black">Registration</h2>
			<table
				style=" margin-left: 20px; margin-top: 20px">
				<tr>
					<td>UserName:</td>
					<td><input type="text" name="username"></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td><input type="submit" name="submit" value="register"></td>
				</tr>
				<tr>
  					<td><a href="login.jsp">Go to Login</a></td>
  				</tr>
			</table>
		</form>
	</div>
</body>
</html>