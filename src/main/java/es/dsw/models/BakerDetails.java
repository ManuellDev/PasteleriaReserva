package es.dsw.models;


import jakarta.persistence.*;

@Entity
@Table(name = "BAKERDETAILS")
public class BakerDetails {

	@Id
    @Column(name = "USERID")
    private Integer userId;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "USERID")
    private User user;
    private String experiencia;
    private String especialidad;

    public BakerDetails() {
    }

    public BakerDetails(User user, String experiencia, String especialidad) {
        this.user = user;
        this.experiencia = experiencia;
        this.especialidad = especialidad;
    }

  

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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


    
    
}

    
