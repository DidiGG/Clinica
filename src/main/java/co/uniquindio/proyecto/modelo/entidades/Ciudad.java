package co.uniquindio.proyecto.modelo.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Ciudad implements Serializable {

    @Id
    private String id_ciudad;
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
