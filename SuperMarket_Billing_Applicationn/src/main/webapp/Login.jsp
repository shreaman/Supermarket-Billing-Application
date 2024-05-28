<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SuperMarket Application Login Page</title>
<link rel="stylesheet" type="text/css" href="CSS/LoginUpdated.css">
</head>
<body>
    <div class="container">
        <h2>Login</h2>
        <form action="login" method="post">
        <div> <%String alart = request.getParameter("error");%>
              <% if(alart!=null){%>
              <h2><p style="color:red"><%= alart %></p></h2>        
              <% }%>
              <label for="email">Email ID</label> 
              <input type="email" id="email" name="email" required>     

         </div>
       <div>
           <label for= "pass">Password</label>
           <input type="password" id="pass" name="pass" required>
       </div>
       <div>
           <input type="submit" value="Login">
       </div>
        </form>
        <div>
       		<a href="getEmail.jsp">
  				<button>Register</button>
			</a>
       </div>
    </div>
</body>
</html>