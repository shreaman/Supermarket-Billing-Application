<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="CSS/AddItems.css">
    <!-- <script src="AddItems.js"></script> Corrected the script source -->
    <title>Add Items</title>
</head>

<body>
    <div class="add_items">
        <h2>Add Items Here</h2>
        <div class="add_item_form">
            <form id="additem" action="Pay_Bill" method="post">
                <div class="menuf_id">
                    <label for="menuf_id">Manufacturer</label>
                    <input type="text" name="menuf_name" id="menuf_id">
                    <ul id="menuf_dropdown" class="dropdownclass" style="display:none"></ul>
                </div>
                <div class="product_id">
                    <label for="product_id">Product</label>
                    <input type="text" name="product_name" id="product_id">
                    <ul id="product_dropdown" class="dropdownclass" style="display:none"></ul>
                </div>
                <div class="product_quantity">
                    <label for="label">Quantity</label>
                    <input type="number" name="quantity_name" id="quantity_id">
                </div>
                <div class="submit">
                    <input type="submit" value="Add Items" id="submitform">
                </div>
            </form>
        </div>
    </div>
    <div class="show_items">
        <h2>Added Items</h2>
        <div class="addedItems">
            <form id="addItemForm" action="BillingPage.jsp" method="post">
                <div class="show_added_items">
                    <table class="items_in_table">
                        <thead>
                            <tr>
                                <th>Manufacturer</th>
                                <th>Product</th>
                                <th>Quantity</th>
                                <th>Price</th>
                                <th>Remove Item</th>
                            </tr>
                        </thead>
                        <tbody id="itemTableBody">  
                        </tbody>
                    </table>
                </div>
                <button id="nextPage">Next</button>
            </form>
        </div>
    </div>
   <script src="JavaScript/Pay_Bill.js"></script> 
    <script src="JavaScript/AddItems.js"></script> 
</body>

</html>