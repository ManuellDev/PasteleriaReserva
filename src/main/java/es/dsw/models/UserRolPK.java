package es.dsw.models;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class UserRolPK implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idUsuario; // Matches type of User.id
	private Integer idRol;  // Matches type of Roles.id
	public UserRolPK(Integer idUsuario, Integer idRol) {
		this.idUsuario = idUsuario;
		this.idRol = idRol;
	}
	public UserRolPK() {
	}
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Integer getIdRol() {
		return idRol;
	}
	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

   
}
