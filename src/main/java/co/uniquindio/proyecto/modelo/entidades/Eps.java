package co.uniquindio.proyecto.modelo.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Eps implements Serializable {

    @OneToMany(mappedBy = "eps")
    private List<Paciente> pacientes;

    @Id
    @NotNull
    @Column(name = "id_eps", unique = true, updatable = false, length = 15)
    private String id_eps;

    @NotNull
    @Column(name = "nombre", unique = true, updatable = true, length = 15)
    private String nombre;

    public Eps() {
        super();
    }

    public String getId_eps() {
        return id_eps;
    }

    public void setId_eps(String id_eps) {
        this.id_eps = id_eps;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Eps eps = (Eps) o;
        return Objects.equals(id_eps, eps.id_eps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_eps);
    }
}


