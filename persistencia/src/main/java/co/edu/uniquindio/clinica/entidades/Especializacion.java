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
public class Especializacion implements Serializable {
    @OneToMany
    private List<Cita> citaList;
    @ManyToMany
    private List<Profile> medico;

    @Id
    @Column(name = "id_especializacion", length = 15)
    private String id_especializacion;

    @Column(name = "titulo",length = 20)
    private String titulo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Especializacion that = (Especializacion) o;
        return Objects.equals(id_especializacion, that.id_especializacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_especializacion);
    }
}
