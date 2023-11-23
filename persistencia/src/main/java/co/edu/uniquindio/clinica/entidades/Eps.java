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
public class Eps implements Serializable {
    @OneToMany(mappedBy = "eps")
    private List<Profile> pacientes;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre", unique = true, length = 15)
    private String nombre;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Eps eps = (Eps) o;
        return Objects.equals(id, eps.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
