package co.uniquindio.proyecto.modelo.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Cita implements Serializable {

    @Id
    @NotNull
    @Column(name = "codigo_cita", unique = true, updatable = false, length = 15)
    private String codigo_cita;

    @NotNull
    @Column(name = "fecha_creacion", unique = true, updatable = false, length = 20)
    private String fecha_creacion;

    @NotNull
    @Column(name = "fecha_cita", unique = true, updatable = false, length = 20)
    private String fechac_cita;

    @NotNull
    @Column(name = "hora_cita", unique = true, updatable = false, length = 15)
    private String hora_cita;

    @NotNull
    @Column(name = "motivo_consulta", unique = true, updatable = true, length = 15)
    private String motivo_consulta;

    @NotNull
    @Column(name = "estado_consulta", unique = true, updatable = true, length = 30)
    private String estado_cita;


    public Cita() {
        super();
    }


    public String getCodigo_cita() {
        return codigo_cita;
    }

    public void setCodigo_cita(String codigo_cita) {
        this.codigo_cita = codigo_cita;
    }

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public String getFechac_cita() {
        return fechac_cita;
    }

    public void setFechac_cita(String fechac_cita) {
        this.fechac_cita = fechac_cita;
    }

    public String getHora_cita() {
        return hora_cita;
    }

    public void setHora_cita(String hor_cita) {
        this.hora_cita = hor_cita;
    }

    public String getMotivo_consulta() {
        return motivo_consulta;
    }

    public void setMotivo_consulta(String motivo_consulta) {
        this.motivo_consulta = motivo_consulta;
    }

    public String getEstado_cita() {
        return estado_cita;
    }

    public void setEstado_cita(String estado_cita) {
        this.estado_cita = estado_cita;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cita cita = (Cita) o;
        return Objects.equals(codigo_cita, cita.codigo_cita);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo_cita);
    }
}
