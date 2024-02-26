// Obtén el token CSRF del formulario si es necesario
var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");


$(document).ready(function() {


    $(".add-to-cart").click(function() {
        let name = $(this).data("name");
        let price = parseFloat($(this).data("price"));
        let id_producto = parseInt($(this).data("id_producto"));

        articulo={ nombre: name, id_producto:id_producto,precio: price };
        updateCart();

        Swal.fire({
            icon: 'success',
            title: '¡Producto añadido!',
            text: `${name} ha sido añadido al carrito.`,
        });
         // Realiza la solicitud utilizando jQuery.ajax
            $.ajax({
                url: '/modificar_carrito',
                type: 'POST',
                contentType: 'application/json',
                beforeSend: request => request.setRequestHeader(header, token),		    	
                data: JSON.stringify(articulo),	
				success: function (data) {
		        console.log(data);
			    },
			    error: function (error) {
			        console.error('Error en la solicitud: ', error);
			    }
	            });
    });

    function updateCart() {

      let count=parseInt($("#cart-count").text());
      $("#cart-count").text(++count);
    }
});