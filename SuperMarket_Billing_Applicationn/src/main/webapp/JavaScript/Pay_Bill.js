document.addEventListener("DOMContentLoaded", function() {
    var manufacturerInput = document.getElementById("menuf_id");
    var manufacturerDropdown = document.getElementById("menuf_dropdown");
    var productInput = document.getElementById("product_id");
    var productDropdown = document.getElementById("product_dropdown");

    var selectedBrand = ""; // Variable to store the selected brand name

    // Function to handle autocomplete for input fields
    function autocomplete(inputField, dropdown, type) {
        inputField.addEventListener("keyup", function() {
            var query = inputField.value.trim();
            if (query !== '') {
                var xhr = new XMLHttpRequest();
                xhr.onreadystatechange = function() {
                    if (xhr.readyState === XMLHttpRequest.DONE) {
                        if (xhr.status === 200) {
                            dropdown.innerHTML = xhr.responseText;
                            dropdown.style.display = "block";
                        } else {
                            console.error('Error:', xhr.status);
                        }
                    }
                };
                xhr.open("POST", "Pay_Bill");
                xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
                // Include selected brand name in data sent to the server
                xhr.send("query=" + query + "&type=" + type + "&brand=" + selectedBrand);
            } else {
                dropdown.style.display = "none";
            }
        });

        dropdown.addEventListener("click", function(event) {
            if (event.target.tagName === 'LI') {
                inputField.value = event.target.textContent;
                dropdown.style.display = "none";
            }
        });

        // Hide dropdown when clicking outside the input field
        document.addEventListener("click", function(event) {
            if (!dropdown.contains(event.target) && !inputField.contains(event.target)) {
                dropdown.style.display = "none";
            }
        });
    }

    // Call the autocomplete function for manufacturer input
    autocomplete(manufacturerInput, manufacturerDropdown, "manufacturer");

    // Call the autocomplete function for product input
    autocomplete(productInput, productDropdown, "product");
    
    // Event listener to update selectedBrand when user selects a manufacturer suggestion
    manufacturerDropdown.addEventListener("click", function(event) {
        if (event.target.tagName === 'LI') {
            selectedBrand = event.target.textContent.trim();
        }
    });
});
