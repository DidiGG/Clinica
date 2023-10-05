package co.uniquindio.proyecto.modelo.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Cita implements Serializable {

    @Id
    private String codigo_cita;
    private String fecha_creacion;
    private String fechac_cita;
    private String hora_cita;
    private String motivo_consulta;
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
