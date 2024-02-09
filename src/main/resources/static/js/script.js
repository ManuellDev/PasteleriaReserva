 function updateQuantity(quantityId, value) {
        const quantityElement = document.getElementById(quantityId);
        let currentQuantity = parseInt(quantityElement.innerText);
        currentQuantity = Math.max(currentQuantity + value, 0);
        quantityElement.innerText = currentQuantity;

        const price = parseInt(quantityElement.parentNode.previousElementSibling.innerText.replace('$', ''));
        const total = currentQuantity * price;

        document.getElementById('total' + quantityId.slice(-1)).innerText = '$' + total.toFixed(2);
    }
    
     // Agregar JavaScript para hacer que el carrusel se desplace automáticamente
    $(document).ready(function(){
        $('.carousel').carousel({
            interval: 2000 // Cambia el intervalo según lo que desees (en milisegundos)
        });
    });