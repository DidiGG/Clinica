package co.uniquindio.proyecto.modelo.entidades;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Entity
public class Horario_atencion implements Serializable {

    @OneToOne
    private Medico medico;

    @Id
    @NotNull
    @Column(name = "id_horario", unique = true, updatable = false, length = 15)
    private String id_horario;

    @NotNull
    @Column(name = "horario_atencion", unique = true, updatable = false, length = 15)
    private String horario_atencion;

    public Horario_atencion() {
        super();
    }

    public String getId_horario() {
        return id_horario;
    }

    public void setId_horario(String id_horario) {
        this.id_horario = id_horario;
    }

    public String getHorario_atencion() {
        return horario_atencion;
    }

    public void setHorario_atencion(String horario_atencion) {
        this.horario_atencion = horario_atencion;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Horario_atencion that = (Horario_atencion) o;
        return Objects.equals(id_horario, that.id_horario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_horario);
    }
}
