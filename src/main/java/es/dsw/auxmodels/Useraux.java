package es.dsw.auxmodels;

public class Useraux {
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String nif;
	private String email;
	private String usuario;
	private String password;
	private String passwordconfirm;
	private Integer rol;
	private String especialidad;
	private String experiencia;
	
	public Useraux(String nombre, String apellido1, String apellido2, String nif, String email, String usuario,
			String password, String passwordconfirm, Integer rol, String especialidad, String experiencia) {
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.nif = nif;
		this.email = email;
		this.usuario = usuario;
		this.password = password;
		this.passwordconfirm = passwordconfirm;
		this.rol = rol;
		this.especialidad = especialidad;
		this.experiencia = experiencia;
	}
	public Useraux() {
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
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordconfirm() {
		return passwordconfirm;
	}
	public void setPasswordconfirm(String passwordconfirm) {
		this.passwordconfirm = passwordconfirm;
	}
	public Integer getRol() {
		return rol;
	}
	public void setRol(Integer rol) {
		this.rol = rol;
	}
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	public String getExperiencia() {
		return experiencia;
	}
	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}
	
	

	
	
	
	
}
