package es.dsw.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
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
    @Column(name="USERNAME_USF")
    private String username;
    @Column(name="PASSWORD_USF")
    private String password;
    
    
    
	public User(Integer userID, String nombre, String apellido1, String apellido2, String nif, String email,String username, String password) {
		this.userID = userID;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.nif = nif;
		this.email = email;
		this.username = username;
		this.password = password;
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
	
	
    
    
	
	
    

	
	
	
    
    
    
    
}
