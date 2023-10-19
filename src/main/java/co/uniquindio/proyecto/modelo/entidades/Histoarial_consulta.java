package co.uniquindio.proyecto.modelo.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Histoarial_consulta implements Serializable {

    @Id
    @NotNull
    @Column(name = "id_historial", unique = true, updatable = false, length = 15)
    private String id_historial;

    @NotNull
    @Column(name = "sintomas", unique = true, updatable = true, length = 100)
    private String sintomas;

    @Column(name = "notas_medico", unique = false, updatable = true, length = 100)
    private String notas_medico;

    @Column(name = "diagnotico", unique = false, updatable = true, length = 100)
    private String diagnostico;

    @Column(name = "tratamiento", unique = false, updatable = true, length = 100)
    private String tratamiento;

    public Histoarial_consulta() {
        super();
    }

    public String getId_historial() {
        return id_historial;
    }

    public void setId_historial(String id_historial) {
        this.id_historial = id_historial;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getNotas_medico() {
        return notas_medico;
    }

    public void setNotas_medico(String notas_medico) {
        this.notas_medico = notas_medico;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Histoarial_consulta that = (Histoarial_consulta) o;
        return Objects.equals(id_historial, that.id_historial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_historial);
    }
}
