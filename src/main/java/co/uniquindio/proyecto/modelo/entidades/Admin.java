package co.uniquindio.proyecto.modelo.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Admin implements Serializable {

    @Id
    @NotNull
    @Column(name = "cedula", unique = true, updatable = false, length = 15)
    private String cedula;

    @NotNull
    @Column(name = "email", unique = true, updatable = true, length = 30)
    private String email;

    @NotNull
    @Column(name = "contrasenia", unique = true, updatable = true, length = 30)
    private String contrasenia;

    public Admin() {
        super();
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasena) {
        this.contrasenia = contrasena;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return Objects.equals(cedula, admin.cedula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cedula);
    }
}
