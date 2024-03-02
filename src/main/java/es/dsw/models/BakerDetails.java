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

    public BakerDetails( String experiencia, String especialidad) {
       
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


    
    
}

    
