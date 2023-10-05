package co.uniquindio.proyecto.modelo.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Medico implements Serializable {

    @Id
    private String cedula_medico;
    private String email;
    private String contrasena;
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
