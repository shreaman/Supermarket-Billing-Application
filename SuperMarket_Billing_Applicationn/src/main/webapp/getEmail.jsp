<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="CSS/VarifyOTP.css">
    <title>Get Email</title>
</head>
<body>
    <div class="mainContaier">
        <form action="EmailVarification" method="post">
        	<label for="getEmail"><h2>Email Address</h2></label>
        	<input type="email" name=getEmail id="getEmail" required>
            <input type="submit" value="submit">
        </form>
    </div>
</body>
</html>