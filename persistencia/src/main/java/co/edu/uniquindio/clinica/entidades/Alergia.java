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
public class Alergia implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre_alergia", length = 30)
    private String nombre_alergia;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alergia alergia = (Alergia) o;
        return Objects.equals(id, alergia.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    @ManyToMany(mappedBy = "alergiaList")
    private List<Profile> pacientesList;
}
