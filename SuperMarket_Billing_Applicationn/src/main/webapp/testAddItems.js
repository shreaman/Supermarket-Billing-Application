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
            newRow.appendChild(menufCell);
            let menufInput = document.createElement('input');
            menufInput.type = 'hidden';
            menufInput.name = 'menuf_name'; // Set the name attribute
            menufInput.value = menuf_name;
            menufCell.appendChild(menufInput);

            let productCell = document.createElement('td');
            productCell.textContent = product_name;
            newRow.appendChild(productCell);
            let productInput = document.createElement('input');
            productInput.type = 'hidden';
            productInput.name = 'product_name'; // Set the name attribute
            productInput.value = product_name;
            productCell.appendChild(productInput);

            let quantityCell = document.createElement('td');
            let quantityInput = document.createElement('input');
            quantityInput.type = 'number';
            quantityInput.name = 'quantity'; // Use input element and set its name attribute
            quantityInput.value = quantity;
            quantityInput.style.width = '50px';
            quantityCell.appendChild(quantityInput);
            newRow.appendChild(quantityCell);

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
