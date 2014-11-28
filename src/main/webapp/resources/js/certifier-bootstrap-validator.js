$(document).ready(function() {
    $('#loginForm').bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	j_username: {
                validators: {
                    notEmpty: {
                        message: 'The username is required'
                    }
                }
            },
            j_password: {
                validators: {
                    notEmpty: {
                        message: 'The password is required'
                    }
                }
            }
        }
    });
    
    
    $('#signupform').bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            email: {
                validators: {
                    notEmpty: {
                        message: 'The email is required'
                    }
                }
            },
            firstname: {
                validators: {
                    notEmpty: {
                        message: 'The firstname is required'
                    }
                }
            },
            lastname: {
                validators: {
                    notEmpty: {
                        message: 'The firstname is required'
                    }
                }
            },
            passwd: {
                validators: {
                    notEmpty: {
                        message: 'The firstname is required'
                    }
                }
            }
        }
    });
    
    
    
    
    
    $('#forgotPasswordForm').bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            email: {
                validators: {
                    notEmpty: {
                        message: 'The email is required'
                    }
                }
            }
        }
    });
    
    
    
});