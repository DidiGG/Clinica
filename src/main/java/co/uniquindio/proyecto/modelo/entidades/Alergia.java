package co.uniquindio.proyecto.modelo.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Alergia implements Serializable {

    @ManyToOne
    private Paciente paciente;

    @Id
    @NotNull
    @Column(name = "id_alergias", unique = true, updatable = false, length = 15)
    private int id_alergia;

    @NotNull
    @Column(name = "nombre_alergia", unique = true, updatable = false, length = 30)
    private String nombre_alergia;

    public Alergia() {
        super();
    }


    public int getId_alergia() {
        return id_alergia;
    }

    public void setId_alergia(int id_alergia) {
        this.id_alergia = id_alergia;
    }

    public String getNombre_alergia() {
        return nombre_alergia;
    }

    public void setNombre_alergia(String nombre_alergia) {
        this.nombre_alergia = nombre_alergia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alergia alergia = (Alergia) o;
        return Objects.equals(id_alergia, alergia.id_alergia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_alergia);
    }
}
