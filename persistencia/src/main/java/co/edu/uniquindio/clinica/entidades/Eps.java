package co.edu.uniquindio.clinica.entidades;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
    @Column(name = "id_eps",length = 15)
    private String id_eps;

    @Column(name = "nombre", unique = true, length = 15)
    private String nombre;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Eps eps = (Eps) o;
        return Objects.equals(id_eps, eps.id_eps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_eps);
    }
}
