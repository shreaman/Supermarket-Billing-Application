<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="CSS/AddInventory.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Remove Product</title>
</head>
<body>
    <h1 class="title">Remove Items</h1>
    <div class="mainContainer">
    
                        
        <form action="removeItem" method="post">
            <div>
                <label for="brandName">Enter Brand Name</label>
                <input type="text" id="brandName" placeholder="Enater product's brand name..." name="brand" required>
            </div>
            <div>
                <label for="productName">Enter Product Name</label>
                <input type="text" id="productName" placeholder="Enater product name..." name="product" required>
            </div>
            <div class="submitClass">
                <input type="submit" value="Remove">
            </div>
            <% String message = request.getParameter("message"); %>
            <% System.out.println(message); %>
            <% if(message!=null){ %>
            <p style="color:red;"><%= message %></p>
            <% } %>
        </form>
    </div>
</body>
</html>