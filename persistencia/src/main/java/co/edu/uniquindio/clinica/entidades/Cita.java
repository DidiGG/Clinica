package co.edu.uniquindio.clinica.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Cita implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "fecha_creacion",length = 20)
    private String fecha_creacion;

    @Column(name = "fecha_cita", length = 20)
    private String fechac_cita;

    @Column(name = "hora_cita", length = 15)
    private String hora_cita;

    @Column(name = "motivo_consulta")
    private String motivo_consulta;

    @Column(name = "estado_consulta", length = 30)
    private String estado_cita;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cita cita = (Cita) o;
        return Objects.equals(id, cita.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    @OneToMany(mappedBy = "cita")
    private List<Pqrs> pqrs;

    @ManyToOne()
    private Especializacion especializacion;

    @ManyToOne
    private Profile medico;

    @ManyToOne
    private Profile paciente;

    @OneToOne(mappedBy = "cita")
    private HistorialConsulta histoarialConsulta;

}
