function validarFormulario() {
    // Obtener referencias a los campos
    var nif = document.getElementById("nif").value.trim();
    var contraseña = document.getElementById("contraseña").value.trim();
    var confirmarContraseña = document.getElementById("confirmar_contraseña").value.trim();
    var email = document.getElementById("email").value.trim();

    // Validar NIF (formato español simple)
    if (!/^\d{8}[a-zA-Z]$/.test(nif)) {
        alert("El NIF no es válido. Debe tener 8 dígitos seguidos de una letra.");
        return false;
    }

    // Validar que las contraseñas coincidan
    if (contraseña !== confirmarContraseña) {
        alert("Las contraseñas no coinciden");
        return false;
    }

    // Validar formato de correo electrónico
    var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRegex.test(email)) {
        alert("El correo electrónico no tiene un formato válido.");
        return false;
    }

    // Otros tipos de validaciones que podrían realizarse
    // Por ejemplo, longitud mínima de contraseña, etc.

    return true; // Envía el formulario si todas las validaciones pasan
}
