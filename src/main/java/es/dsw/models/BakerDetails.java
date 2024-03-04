package es.dsw.models;


import jakarta.persistence.*;

@Entity
@Table(name = "BAKERDETAILS")
public class BakerDetails {

	@Id
    @Column(name = "USERID")
    private Integer userId;

    
    private String experiencia;
    private String especialidad;
    @OneToOne
    @JoinColumn(name = "USERID")
    private User user;
    
    public BakerDetails() {
    }

    public BakerDetails(Integer userId, String experiencia, String especialidad) {
		super();
		this.userId = userId;
		this.experiencia = experiencia;
		this.especialidad = especialidad;
	}

	public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


    
    
}

    
