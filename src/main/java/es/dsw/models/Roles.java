package es.dsw.models;

import jakarta.persistence.*;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "roles")
public class Roles implements GrantedAuthority {
  
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDROL_RF")
    private Integer id;

    @Column(name = "ROLCODE_RF")
    private String roleCode;

    @Column(name = "ROLNAME_RF")
    private String roleName;

	public Roles(Integer id, String roleCode, String roleName) {
		this.id = id;
		this.roleCode = roleCode;
		this.roleName = roleName;
	}
	public Roles() {
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	// Implementación del método de GrantedAuthority
    @Override
    public String getAuthority() {
        // Devolver el código del rol como autoridad
        return roleCode;
    }
}
