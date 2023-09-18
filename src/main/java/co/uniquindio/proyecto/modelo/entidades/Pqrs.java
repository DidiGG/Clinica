package co.uniquindio.proyecto.modelo.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Pqrs implements Serializable {

    @Id
    private String radicado;
    private String titulo;
    private String contenido;
    private String fecha_creacion;
    private String respuesta_peticion;

    public Pqrs() {
        super();
    }


    public String getRadicado() {
        return radicado;
    }

    public void setRadicado(String radicado) {
        this.radicado = radicado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
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
        Pqrs pqrs = (Pqrs) o;
        return Objects.equals(radicado, pqrs.radicado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(radicado);
    }
}
