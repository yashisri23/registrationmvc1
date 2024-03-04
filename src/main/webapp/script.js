jQuery(document).ready(function($) {
    $('#frm').validate({
        rules: {
            fullname: "required",
            email: "required",
            password: {
                required: true,
                minlength: 6,
            },
            repeat_password: {
                required: true,
                equalTo: "#password"
            },
            address: "required"
        },
        messages: {
            fullname: "Please enter your name",
            email: "Please enter your email",
            password: {
                required: "Please enter your password",
                minlength: "Password must be at least 6 characters long",
            },
            repeat_password: {
                required: "Please repeat your password",
                equalTo: "Passwords do not match"
            },
            address: "Please enter your address"
        },
        submitHandler: function(form) {
            form.submit();
        }
    });
});
