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
        
        // Crear la tabla
        let table = $('<table>').addClass('table');
        let tbody = $('<tbody>');
        
        cart.forEach(function(item) {
            // Crear una fila para cada producto
            let row = $('<tr>');
            row.append($('<td>').text(item.name));
            row.append($('<td>').text('$' + item.price.toFixed(2)));
            
            // Agregar la fila a tbody
            tbody.append(row);
            
            // Calcular el total
            total += item.price;
        });
        
        // Agregar tbody a la tabla
        table.append(tbody);
        
        // Agregar la tabla al contenedor
        $("#cart-items").append(table);
        
        $("#cart-total").text(`Total: $${total.toFixed(2)}`);
        
        // Actualizar contador del carrito
        $("#cart-count").text(cart.length);
    }
});
