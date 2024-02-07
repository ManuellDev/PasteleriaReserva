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
    $(document).ready(function() {
    let cart = [];
    
    $(".add-to-cart").click(function() {
        let name = $(this).data("name");
        let price = parseFloat($(this).data("price"));
        
        cart.push({ name: name, price: price });
        updateCart();
        
        Swal.fire({
            icon: 'success',
            title: '¡Producto añadido!',
            text: `${name} ha sido añadido al carrito.`,
        });
    });
    
    function updateCart() {
        let total = 0;
        $("#cart-items").empty();
        
        cart.forEach(function(item) {
            $("#cart-items").append(`<li class="list-group-item">${item.name} - $${item.price}</li>`);
            total += item.price;
        });
        
        $("#cart-total").text(`Total: $${total.toFixed(2)}`);
        
        // Actualizar contador del carrito
        $("#cart-count").text(cart.length);
    }
    
    
});

$(document).ready(function() {
    let cart = JSON.parse(localStorage.getItem('cart')) || [];
    
    function updateCart() {
        let total = 0;
        $("#cart-items").empty();
        
        cart.forEach(function(item) {
            $("#cart-items").append(`<li class="list-group-item">${item.name} - $${item.price}</li>`);
            total += item.price;
        });
        
        $("#cart-total").text(`Total: $${total.toFixed(2)}`);
    }
    
    updateCart();
});

