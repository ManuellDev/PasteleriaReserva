package es.dsw.models;



import jakarta.persistence.*;

@Entity
@Table(name = "USERROL")
public class Userrol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UserRolPK id;


    @ManyToOne
    @MapsId("idUsuario") // Part of composite key
    @JoinColumn(name = "IDUSER_URF", nullable = false)
    private User user;

    @ManyToOne
    @MapsId("idRol")  // Part of composite key
    @JoinColumn(name = "IDROL_URF", nullable = false)
    private Roles rol;

   
    

	public Userrol(User user, Roles rol) {
		this.user = user;
		this.rol = rol;
	}
	
	public Userrol() {
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Roles getRol() {
		return rol;
	}

	public void setRol(Roles rol) {
		this.rol = rol;
	}
	public Userrol setId(UserRolPK id) {
	    this.id = id;
	    return this;
	}
}
