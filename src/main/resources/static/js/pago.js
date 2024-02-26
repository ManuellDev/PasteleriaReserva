$(document).ready(function() {
    $('#payment-form').submit(function() {
 

        // Obtener los valores de los campos del formulario
        var cardNumber = $('#card-number').val();
        var expiry = $('#expiry').val();
        var cvv = $('#cvv').val();

        // Validar que los campos no estén vacíos
        if (cardNumber.trim() === '' || expiry.trim() === '' || cvv.trim() === '') {
            alert('Por favor completa todos los campos del formulario.');
            return false;
        }

        // Validar el formato del número de tarjeta (puedes agregar tu propia lógica aquí)
        if (!isValidCardNumber(cardNumber)) {
            alert('El número de tarjeta no es válido.');
            return false;
        }

        // Validar el formato del CVV (puedes agregar tu propia lógica aquí)
        if (!isValidCVV(cvv)) {
            alert('El CVV no es válido.');
            return false;
        }

        // Validar la fecha de vencimiento
        if (!isValidExpiryDate(expiry)) {
            alert('La fecha de vencimiento no es válida.');
            return false;
        }
        
        alert('¡Pago realizado con éxito!');
  return true;
    });

       
});

// Función para validar el formato del número de tarjeta (solo un ejemplo)
function isValidCardNumber(cardNumber) {
    // Verificar si es un número de tarjeta válido
    // Esta es solo una validación de ejemplo, debes adaptarla según tus requisitos
    return /^\d{16}$/.test(cardNumber);
}

// Función para validar el formato del CVV (solo un ejemplo)
function isValidCVV(cvv) {
    // Verificar si es un CVV válido
    // Esta es solo una validación de ejemplo, debes adaptarla según tus requisitos
    return /^\d{3,4}$/.test(cvv);
}

// Función para validar la fecha de vencimiento
function isValidExpiryDate(expiry) {
    // Verificar si es una fecha de vencimiento válida en el formato MM/AA
    var parts = expiry.split('/');
    if (parts.length !== 2) {
        return false;
    }

    var month = parseInt(parts[0], 10);
    var year = parseInt(parts[1], 10);
    var currentDate = new Date();
    var currentYear = currentDate.getFullYear() % 100; // Obtener los últimos dos dígitos del año actual

    // Verificar si el año es válido (debe ser mayor o igual al año actual)
    if (year < currentYear) {
        return false;
    }

    // Verificar si el mes es válido (debe estar entre 1 y 12)
    if (month < 1 || month > 12) {
        return false;
    }

    // Si la fecha de vencimiento es válida
    return true;
}
