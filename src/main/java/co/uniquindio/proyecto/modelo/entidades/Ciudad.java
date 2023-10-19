package co.uniquindio.proyecto.modelo.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Ciudad implements Serializable {

    @OneToOne
    private Medico medico;

    @OneToOne
    private Paciente paciente;

    @ManyToOne
    private Departamento departamento;

    @Id
    @NotNull
    @Column(name = "id_ciudad", unique = true, updatable = false, length = 15)
    private String id_ciudad;

    @NotNull
    @Column(name = "nombre", unique = true, updatable = true, length = 20)
    private String nombre;

    public Ciudad() {
        super();
    }

    public String getId_ciudad() {
        return id_ciudad;
    }

    public void setId_ciudad(String id_ciudad) {
        this.id_ciudad = id_ciudad;
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
        Ciudad ciudad = (Ciudad) o;
        return Objects.equals(id_ciudad, ciudad.id_ciudad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_ciudad);
    }
}
