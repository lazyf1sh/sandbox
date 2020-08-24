$('#myForm').on('submit', function(e)
{
    console.log('submit 1')
    // Prevent form submission by the browser
    e.preventDefault();
});