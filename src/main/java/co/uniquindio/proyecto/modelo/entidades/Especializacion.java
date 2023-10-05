package co.uniquindio.proyecto.modelo.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Especializacion implements Serializable {

    @Id
    private String id_especializacion;
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