package co.edu.uniquindio.clinica.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class HistorialConsulta implements Serializable {

    @OneToOne
    private Cita cita;

    @OneToOne
    private Profile paciente;

    @ManyToOne
    private  Profile medico;

    @Id
    @Column(name = "id_historial", length = 15)
    private String id_historial;

    @Column(name = "sintomas", length = 100)
    private String sintomas;

    @Column(name = "notas_medico", length = 100)
    private String notas_medico;

    @Column(name = "diagnotico", length = 100)
    private String diagnostico;

    @Column(name = "tratamiento", length = 100)
    private String tratamiento;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistorialConsulta that = (HistorialConsulta) o;
        return Objects.equals(id_historial, that.id_historial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_historial);
    }
}
