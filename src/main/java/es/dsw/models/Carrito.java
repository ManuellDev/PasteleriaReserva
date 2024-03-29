package es.dsw.models;



import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "CARRITO")
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carrito")
    private Integer id;

    @Column(name = "cantidad_producto")
    private Integer cantidadProducto;

    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;
    @Column(name = "fechahora", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fechahora;
 

	public Carrito(Integer id, Integer cantidadProducto, Pedido pedido, Producto producto) {
		this.id = id;
		this.cantidadProducto = cantidadProducto;
		this.pedido = pedido;
		this.producto = producto;
	}

	public Carrito() {
        this.fechahora = LocalDateTime.now(); // Establecer la fecha y hora actual al crear el pedido

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCantidadProducto() {
		return cantidadProducto;
	}

	public void setCantidadProducto(Integer cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	

   

    // Constructor, getters, setters
    
    
}
