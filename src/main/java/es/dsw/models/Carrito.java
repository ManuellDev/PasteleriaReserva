package es.dsw.models;

public class Carrito {
	private int id_carrito;
	private int id_pedido;
	private int id_producto;
	private int cantidad_producto;
	private String nombre;
	private Float precio;
	
	
	public Carrito(int id_carrito, int id_pedido, int id_producto, int cantidad_producto, String nombre, Float precio) {
		super();
		this.id_carrito = id_carrito;
		this.id_pedido = id_pedido;
		this.id_producto = id_producto;
		this.cantidad_producto = cantidad_producto;
		this.nombre = nombre;
		this.precio = precio;
	}
	public Carrito() {
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	
	
	public Carrito(int id_carrito, int id_pedido, int id_producto, int cantidad_producto) {
		this.id_carrito = id_carrito;
		this.id_pedido = id_pedido;
		this.id_producto = id_producto;
		this.cantidad_producto = cantidad_producto;
	}
	public int getId_carrito() {
		return id_carrito;
	}
	public void setId_carrito(int id_carrito) {
		this.id_carrito = id_carrito;
	}
	public int getId_pedido() {
		return id_pedido;
	}
	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}
	public int getId_producto() {
		return id_producto;
	}
	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}
	public int getCantidad_producto() {
		return cantidad_producto;
	}
	public void setCantidad_producto(int cantidad_producto) {
		this.cantidad_producto = cantidad_producto;
	}
	
	
	

}
