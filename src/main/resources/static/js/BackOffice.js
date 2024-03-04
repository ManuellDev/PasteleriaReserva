// Obtén el token CSRF del formulario si es necesario
var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");


$("#role").change(function() {
		if($("#role").val()==3){
			  $("#campo-oculto").fadeIn();
		}else{
			 $("#campo-oculto").fadeOut();
		}
});

$('body').on('click', '#crearusuario', function() {
    var formData = {
        nombre: $('#nombre').val(),
        apellido1: $('#apellido1').val(),
        apellido2: $('#apellido2').val(),
        nif: $('#nif').val(),
        email: $('#email').val(),
        usuario: $('#username').val(),
        password: $('#password').val(),
        passwordconfirm: $('#confirm_password').val(),
        rol: $('#role').val(),
        especialidad: $('#especialidad').val(),
        experiencia: $('#experiencia').val()
    };

    // Información de autorización
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");

    // Enviar la solicitud AJAX
    $.ajax({
        url: '/CrearUsuario',
        type: 'POST',
        contentType: 'application/json', // Sin punto y coma
        data: JSON.stringify(formData), 
        beforeSend: request => request.setRequestHeader(header, token),
        success: function(data) { // Inicio de la función success
            addNewRow(data);
            console.log(data);
        }, // Cierre de la función success
        error: function () { 
            alert('Error en la solicitud: El usuario ya ha sido creado ');
        }
    });
});