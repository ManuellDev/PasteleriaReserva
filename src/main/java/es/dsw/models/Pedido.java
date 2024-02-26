package es.dsw.models;





import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "PEDIDO")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private User cliente;

    @ManyToOne
    @JoinColumn(name = "id_pastelero")
    private User pastelero;

    @Column(name = "estado", nullable = false, columnDefinition = "varchar(255) default 'Pendiente'")
    private String estado;
    @Column(name = "fechahora", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fechahora;
 
	public Pedido(Integer id, User cliente, User pastelero, String estado) {
		this.id = id;
		this.cliente = cliente;
		this.pastelero = pastelero;
		this.estado = estado;
	}

	public Pedido() {
	    this.estado = "Pendiente";
        this.fechahora = LocalDateTime.now(); // Establecer la fecha y hora actual al crear el pedido


	}

	public LocalDateTime getFechahora() {
		return fechahora;
	}

	public void setFechahora(LocalDateTime fechahora) {
		this.fechahora = fechahora;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getCliente() {
		return cliente;
	}

	public void setCliente(User cliente) {
		this.cliente = cliente;
	}

	public User getPastelero() {
		return pastelero;
	}

	public void setPastelero(User pastelero) {
		this.pastelero = pastelero;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	

   

}
