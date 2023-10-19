package co.uniquindio.proyecto.modelo.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Especializacion implements Serializable {

    @OneToOne
    private Cita cita;

    @ManyToOne
    private Medico medico;

    @Id
    @NotNull
    @Column(name = "id_especializacion", unique = true, updatable = false, length = 15)
    private String id_especializacion;

    @NotNull
    @Column(name = "titulo", unique = true, updatable = true, length = 20)
    private String titulo;

    public Especializacion() {
        super();
    }

    public String getId_especializacion() {
        return id_especializacion;
    }

    public void setId_especializacion(String id_especializacion) {
        this.id_especializacion = id_especializacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Especializacion that = (Especializacion) o;
        return Objects.equals(id_especializacion, that.id_especializacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_especializacion);
    }


}