package co.uniquindio.proyecto.modelo.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Accion implements Serializable {

    @OneToOne
    private Pqrs pqrs;

    @Id
    @NotNull
    @Column(name = "id_action", unique = true, nullable = false, updatable = false)
    private int id_accion;

    @NotNull
    @Column(name = "respuesta_peticion", unique = true,  updatable = true, length = 30)
    private String respuesta_peticion;

    public Accion(){
        super();
    }

    public int getId_accion() {
        return id_accion;
    }

    public void setId_accion(int id_accion) {
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
