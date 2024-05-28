document.addEventListener('DOMContentLoaded', function () {
    document.getElementById('additem').addEventListener('submit', function(event) {
        event.preventDefault();

        // Get the values from the form fields
        let menuf_name = document.getElementById('menuf_id').value.trim();
        let product_name = document.getElementById('product_id').value.trim();
        let quantity = document.getElementById('quantity_id').value.trim();

        // Check if all form fields are not empty
        if (menuf_name !== '' && product_name !== '' && quantity !== '') {
            // Create a new row element
            let newRow = document.createElement('tr');

            // Create and append table cells for each form field value
            let menufCell = document.createElement('td');
            menufCell.textContent = menuf_name;
            menufCell.id = 'brand';
            newRow.appendChild(menufCell);

            let productCell = document.createElement('td');
            productCell.textContent = product_name;
            productCell.id = 'product';
            newRow.appendChild(productCell);

            let quantityCell = document.createElement('td');
            let quantityInput = document.createElement('input');
            quantityInput.type = 'number';
            quantityInput.id = 'quantity';
            quantityInput.value = quantity;
            quantityInput.style.width = '50px';
            quantityInput.addEventListener('input', function() {
                quantity = quantityInput.value.trim(); // Update quantity value when input changes
            });
            quantityCell.appendChild(quantityInput);
            newRow.appendChild(quantityCell);

            // Create a cell to display the price
            let priceCell = document.createElement('td');
            priceCell.textContent = 'Loading...'; // Initially show "Loading..." until price is fetched
            newRow.appendChild(priceCell);

            // Create a button cell with a remove button
            let buttonCell = document.createElement('td');
            let removeButton = document.createElement('button');
            removeButton.textContent = 'Remove';
            removeButton.style.cursor = 'pointer';
            removeButton.addEventListener('click', function() {
                newRow.remove(); // Remove the row when the button is clicked
            });
            buttonCell.appendChild(removeButton);
            newRow.appendChild(buttonCell);

            // Append the new row to the table body
            document.getElementById('itemTableBody').appendChild(newRow);

            // Make an HTTP request to the servlet to get the price
            let xhr = new XMLHttpRequest();
            xhr.open('POST', 'Add_Items');
            xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
            xhr.onload = function() {
                if (xhr.status === 200) {
                    let price = xhr.responseText;
                    priceCell.textContent = price;
                } else {
                    priceCell.textContent = 'Error fetching price';
                }
            };
            xhr.send('menuf_name=' + encodeURIComponent(menuf_name) + '&product_name=' + encodeURIComponent(product_name)+ '&quantity=' + encodeURIComponent(quantity));
        } else {
            // If any form field is empty, display an alert or handle it as needed
            alert('Please fill in all fields.');
        }

        // Clear the form fields after adding the item
        document.getElementById('menuf_id').value = '';
        document.getElementById('product_id').value = '';
        document.getElementById('quantity_id').value = '';
    });
});
