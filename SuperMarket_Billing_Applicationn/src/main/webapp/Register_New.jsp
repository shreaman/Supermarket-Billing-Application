<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1"">
        <title>New User Registration</title>
        <link rel="stylesheet" type="text/css" href="CSS/RegisterNew.css">
    </head>
    <body>
        <div class="register">
            <h2>Register</h2>
            <form action="register_new" method="post">
                <div>
                    <label for="email">Email ID</label>
                    <input type="email" id="email" name="email" required>
                    <% String alert1 = request.getParameter("error_email"); %>
                       <% if(alert1 != null) { %>
                       <p><%= alert1 %></p>
                       <% } %>                              
                </div>
                <div>
                    <label for="role">Job Role</label>
                    <select id="role" name="role">
                        <option value="Cashier">Customer</option>
                        <option value="Admin">Admin</option>
                    </select>
                </div>
                <div>
                    <label for="u_name">Username</label>
                    <input type="text" id="u_name" name="username" minlength="6" required>
                </div>
                <div>
                    <label for="pass">Password</label>
                    <input type="password" id="pass" name="pass" required>
                </div>
                <div>
                    <label for="re_enter">Re-Enter Password</label>
                    <input type="password" id="re_enter" name="re_enter">
                    
                       <% String alert2 = request.getParameter("error_match"); %>
                       <% if(alert2 != null) { %>
                       <p><%= alert2 %></p>
                       <% } %>
                </div>
                <div>
                    <input type="submit" value="Register">
                    <% String alert3 = request.getParameter("message"); %>
                       <% if(alert3 != null) { %>
                       <p style="color: green; "><%= alert3 %></p>
                       <% } %>
                </div>
            </form>
            <div>
       		<a href="Login.jsp">
  				<button>Login</button>
			</a>
       </div>
        </div>
    </body>
</html>