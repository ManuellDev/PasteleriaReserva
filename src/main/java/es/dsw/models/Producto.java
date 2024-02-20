package es.dsw.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Producto {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_producto")
	private int id_producto;
	@Column(name="nombre")
	private String nombre;
	@Column(name="descripcion")
	private String descripcion;
	@Column(name="imagen")
	private String imagen;
	@Column(name="precio")
	private float precio;

	public Producto(int id_producto, String nombre, String descripcion, float precio, String imagen) {
	
		this.id_producto = id_producto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.imagen = imagen;
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
	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	
	

}
