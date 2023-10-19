package co.uniquindio.proyecto.modelo.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Medico implements Serializable {

    @OneToMany(mappedBy = "medico")
    private List<Pqrs> pqrs;

    @OneToMany(mappedBy = "medico")
    private List<Cita> citas;

    @OneToMany(mappedBy = "medico")
    private List<Especializacion> especializaciones;

    @OneToOne(mappedBy = "medico")
    private Horario_atencion horarioAtencion;

    @OneToOne(mappedBy = "medico")
    private Ciudad ciudad;

    @ManyToOne
    private Usuario usuario;

    @OneToMany(mappedBy = "medico")
    private List<Histoarial_consulta> histoarialConsultas;

    @Id
    @NotNull
    @Column(name = "cedula_medico", unique = true, updatable = false, length = 15)
    private String cedula_medico;

    @NotNull
    @Email
    @Column(name = "email", unique = true, updatable = true, length = 50)
    private String email;

    @NotNull
    @Column(name = "contrasenia", unique = true, updatable = true, length = 50)
    private String contrasena;

    @NotNull
    @Column(name = "consultorio", unique = true, updatable = true, length = 10)
    private String consultorio;

    public Medico() {
        super();
    }

    public String getCedula_medico() {
        return cedula_medico;
    }

    public void setCedula_medico(String cedula_medico) {
        this.cedula_medico = cedula_medico;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getHorario_atencion() {
        return consultorio;
    }

    public void setHorario_atencion(String horario_atencion) {
        this.consultorio = horario_atencion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medico medico = (Medico) o;
        return Objects.equals(cedula_medico, medico.cedula_medico);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cedula_medico);
    }
}
