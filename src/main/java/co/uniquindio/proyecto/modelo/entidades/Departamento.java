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
public class Departamento implements Serializable {

    @OneToMany(mappedBy = "departamento")
    private List<Ciudad> ciudads;

    @Id
    @NotNull
    @Column(name = "id_departamento", unique = true, updatable = false, length = 15)
    private String id_departamento;

    @NotNull
    @Column(name = "nombre", unique = true, updatable = true, length = 20)
    private String nombre;

    public Departamento() {
        super();
    }

    public String getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(String id_departamento) {
        this.id_departamento = id_departamento;
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
        Departamento that = (Departamento) o;
        return Objects.equals(id_departamento, that.id_departamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_departamento);
    }
}
