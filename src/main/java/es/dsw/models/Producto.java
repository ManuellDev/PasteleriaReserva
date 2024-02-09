package es.dsw.models;

public class Producto {
	
	private int id_producto;
	private String nombre;
	private String descripcion;
	private float precio;
	public Producto(int id_producto, String nombre, String descripcion, float precio) {
		this.id_producto = id_producto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
	}
	
	
	public Producto() {
		// TODO Auto-generated constructor stub
	}


	public int getId_producto() {
		return id_producto;
	}
	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	
	

}
