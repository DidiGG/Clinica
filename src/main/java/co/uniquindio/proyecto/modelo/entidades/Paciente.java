package co.uniquindio.proyecto.modelo.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Paciente implements Serializable {

    @Id
    @NotNull
    @Column(name = "cedula_paciente", unique = true, updatable = false, length = 15)
    private String cedula_paciente;

    @NotNull
    @Email
    @Column(name = "email", unique = true, updatable = true, length = 50)
    private String email;

    @NotNull
    @Column(name = "contrasenia", unique = true, updatable = true, length = 50)
    private String contrasenia;

    @NotNull
    @Column(name = "fecha_nacimiento", unique = true, updatable = false, length = 20)
    private String fecha_nacimiento;

    @NotNull
    @Column(name = " tipo_sangre", unique = true, updatable = false, length = 10)
    private String tipo_sangre;

    @NotNull
    @Column(name = "genero", unique = true, updatable = false, length = 10)
    private String genero;

    public Paciente() {
        super();
    }

    public String getCedula_paciente() {
        return cedula_paciente;
    }

    public void setCedula_paciente(String cedula_paciente) {
        this.cedula_paciente = cedula_paciente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String correo) {
        this.email = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasena) {
        this.contrasenia = contrasena;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getTipo_sangre() {
        return tipo_sangre;
    }

    public void setTipo_sangre(String tipo_sangre) {
        this.tipo_sangre = tipo_sangre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paciente paciente = (Paciente) o;
        return Objects.equals(cedula_paciente, paciente.cedula_paciente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cedula_paciente);
    }
}