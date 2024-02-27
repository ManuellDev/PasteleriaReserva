package es.dsw.models;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "PAGO")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_facturacion")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private User usuario;

    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "numero_tarjeta")
    private String numeroTarjeta;

    @Column(name = "cvv")
    private String cvv;

    @Column(name = "expiration_date")
    private String expirationDate;
    @Column(name = "fechahora", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fechahora;
    // Constructor, getters, setters

	public Pago(Integer id, User usuario, Pedido pedido, String nombre, String numeroTarjeta, String cvv,
			String expirationDate) {
		this.id = id;
		this.usuario = usuario;
		this.pedido = pedido;
		this.nombre = nombre;
		this.numeroTarjeta = numeroTarjeta;
		this.cvv = cvv;
		this.expirationDate = expirationDate;
	}
	public Pago() {
        this.fechahora = LocalDateTime.now(); // Establecer la fecha y hora actual al crear el pedido

	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public User getUsuario() {
		return usuario;
	}
	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}
	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public String getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	
    
    
}
