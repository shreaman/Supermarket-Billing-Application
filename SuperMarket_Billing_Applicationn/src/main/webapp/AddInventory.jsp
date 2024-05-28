<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="CSS/AddInventory.css">
    <title>Product Input</title>
</head>
<body>
    <h1 class="title">Add Items</h1>
    <div class="mainContainer">
    <% String alert = request.getParameter("message"); %>
                       <% if(alert != null) { %>
                       <p style="color: green; "><%= alert %></p>
                       <% } %> 
        <form action="AddItemToInventory" method="post">
            <div>
                <label for="brandName">Enter Brand Name</label>
                <input type="text" id="brandName" placeholder="Enater product's brand name..." name="brand" required>
            </div>
            <div>
                <label for="productName">Enter Product Name</label>
                <input type="text" id="productName" placeholder="Enater product name..." name="product" required>
            </div>
            <div>
                <label for="productQuantity">Quantity</label>
                <input type="number" id="productQuantity" placeholder="Enater product quantity..." name="quantity" required>
            </div>
            <div>
                <label for="productPrice">Price par unit</label>
                <input type="number" id="productPrice" placeholder="Enater product price..." name="price" required>
            </div>
            <div>
                <label for="productTax">Tax</label>
                <input type="number" inputmode="numeric" id="quantity" placeholder="Enter tax..." name="tax"  required>
            </div>
            <div>
                <label for="productDiscount">Discount</label>
                <input type="number"  id="productDiscount" placeholder="Discount..." name="discount" required>
            </div>
            <div class="submitClass">
                <input type="submit" value="Add Item">
            </div>
        </form>
    </div>
</body>
</html>