package es.dsw.models;

import java.util.Collection;
import java.util.Set;

import jakarta.persistence.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "users")
public class User implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="IDUSER_USF")
    private Integer userID;
    @Column(name="NAME_USF")
    private String nombre;
    @Column(name="FIRSTSURNAME_USF")
    private String apellido1;
    @Column(name="SECOUNDSURNAME_USF")
    private String apellido2;
    @Column(name="NIF")
    private String nif;
    @Column(name="EMAIL_USF")
    private String email;
    @Column(name="USERNAME_USF",nullable=false, unique=true)
    private String username;
    @Column(name="PASSWORD_USF")
    private String password;
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Set<Pago> pagos;
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private Set<Pedido> pedidos;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "USERROL",
            joinColumns = @JoinColumn(name = "IDUSER_URF"),
            inverseJoinColumns = @JoinColumn(name = "IDROL_URF")
    )
    private Set<Roles> roles;
    @OneToMany(mappedBy = "pastelero" , cascade = CascadeType.ALL)
    private Set<Pedido> pedidosComoPastelero;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private BakerDetails bakerDetails;
    
    
    
    


    public User(Integer userID, String nombre, String apellido1, String apellido2, String nif, String email,
			String username, String password, Set<Roles> roles) {
		this.userID = userID;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.nif = nif;
		this.email = email;
		this.username = username;
		this.password = password;
		this.roles = roles;
	}
   
	public User() {
	}
	


	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Pago> getPagos() {
		return pagos;
	}

	public void setPagos(Set<Pago> pagos) {
		this.pagos = pagos;
	}

	public Set<Roles> getRoles() {
		return roles;
	}

	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}

	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Devolver los roles del usuario como autoridades
        return roles;
    }

    @Override
    public boolean isAccountNonExpired() {
        // Devolver true si la cuenta no está expirada
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // Devolver true si la cuenta no está bloqueada
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // Devolver true si las credenciales no están expiradas
        return true;
    }

    @Override
    public boolean isEnabled() {
        // Devolver true si el usuario está habilitado
        return true;
    }
}
