package co.uniquindio.proyecto.modelo.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Accion implements Serializable {

    @Id
    private String id_accion;

    private String respuesta_peticion;

    public Accion(){
        super();
    }

    public String getId_accion() {
        return id_accion;
    }

    public void setId_accion(String id_accion) {
        this.id_accion = id_accion;
    }

    public String getRespuesta_peticion() {
        return respuesta_peticion;
    }

    public void setRespuesta_peticion(String respuesta_peticion) {
        this.respuesta_peticion = respuesta_peticion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accion accion = (Accion) o;
        return Objects.equals(id_accion, accion.id_accion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_accion);
    }
}
