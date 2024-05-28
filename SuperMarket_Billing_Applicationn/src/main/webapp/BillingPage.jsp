<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Payment Interface</title>
    <link rel="stylesheet" href="CSS/styles.css">
</head>
<body>
    <div class="container">
        <h1>Payment Interface</h1>
        <form id="paymentForm">
            <div class="form-group">
                <label for="cardNumber">Card Number:</label>
                <input type="text" id="cardNumber" name="cardNumber" placeholder="1234 5678 9101 1121" required>
            </div>
            <div class="form-group">
                <label for="expDate">Expiration Date:</label>
                <input type="text" id="expDate" name="expDate" placeholder="MM/YY" required>
            </div>
            <div class="form-group">
                <label for="cvv">CVV:</label>
                <input type="text" id="cvv" name="cvv" placeholder="123" required>
            </div>
            <div class="form-group">
                <label for="name">Name on Card:</label>
                <input type="text" id="name" name="name" placeholder="John Doe" required>
            </div>
            <button type="submit">Pay Now</button>
        </form>
    </div>
</body>
</html>
