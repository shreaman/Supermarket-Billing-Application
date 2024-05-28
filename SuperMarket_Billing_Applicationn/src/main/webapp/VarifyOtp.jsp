<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="CSS/VarifyOTP.css">
    <title>Varify Otp</title>
</head>
<body>
    <div class="mainContaier">
        <form action="verifyOTP" method="post">
            <label for="OTP"><h2>Enter otp</h2></label>
            <h4>OTP is send <span id = "timer">00:00</span></h4>
            <input type="text" name="otp" id="OTP" pattern="[0-9]*" required>
            <% String alert1 = request.getParameter("error"); %>
                       <% if(alert1 != null) { %>
                       <p style="color: red; text-align:center; "><%= alert1 %></p>
                       <% } %> 
            <input type="submit" value="submit">
        </form>
    </div>
    <script src="JavaScript/timer.js"></script>
</body>
</html>