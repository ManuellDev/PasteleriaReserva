// Generar el código QR
    function generarQR() {
      var qrCanvas = document.getElementById('qrCanvas');
      var nombre = document.getElementById('nombre').innerText;
      var nif = document.getElementById('nif').innerText;
      var email = document.getElementById('email').innerText;
      var qrData = "Cliente: " + nombre + "\nNIF: " + nif + "\nEmail: " + email;
      new QRious({
        element: qrCanvas,
        value: qrData,
        size: 200
      });
    }

    // Generar el código QR al cargar la página
    window.onload = function() {
      generarQR();
    };