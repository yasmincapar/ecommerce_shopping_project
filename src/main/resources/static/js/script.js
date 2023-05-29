$(document).ready(function() {
  $('#addProductForm').submit(function(event) {
    event.preventDefault();

    // Serialize the form data
    var formData = $(this).serialize();

    // Send an AJAX request to add the product
    $.ajax({
      url: '/addnewproduct',
      type: 'POST',
      data: formData,
      success: function(response) {
        // Update the message element with the success message
        $('#message').text('Product added successfully.');
      },
      error: function() {
        // Update the message element with the error message
        $('#message').text('An error occurred while adding the product.');
      }
    });
  });
});