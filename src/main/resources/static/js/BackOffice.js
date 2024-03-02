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

