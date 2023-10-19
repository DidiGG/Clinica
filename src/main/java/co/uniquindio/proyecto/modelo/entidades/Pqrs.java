package co.uniquindio.proyecto.modelo.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Pqrs implements Serializable {

    @OneToOne(mappedBy = "pqrs")
    private Accion accion;

    @ManyToOne
    private Admin admin;

    @ManyToOne
    private Cita cita;

    @ManyToOne
    private Medico medico;

    @Id
    @NotNull
    @Column(name = "radicado", unique = true, updatable = false, length = 15)
    private String radicado;

    @NotNull
    @Column(name = "titulo", unique = true, updatable = false, length = 30)
    private String titulo;

    @NotNull
    @Column(name = "contenido", unique = true, updatable = false, length = 100)
    private String contenido;

    @NotNull
    @Column(name = "fecha_creacion", unique = true, updatable = false, length = 15)
    private String fecha_creacion;


    @Column(name = "respuesta_peticion", unique = true, updatable = false, length = 100)
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
