package co.edu.uniquindio.clinica.entidades;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class HorarioAtencion implements Serializable {
    @OneToOne
    private Profile medico;

    @Id
    @Column(name = "id_horario", length = 15)
    private String id_horario;
// date inicio date final localtime LocalTime java java.time.localtime
    @Column(name = "horario_atencion", length = 15)
    private String horario_atencion;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HorarioAtencion that = (HorarioAtencion) o;
        return Objects.equals(id_horario, that.id_horario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_horario);
    }
}
