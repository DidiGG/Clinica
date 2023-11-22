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
public class Ciudad implements Serializable {

    //medico y paciente
    @ManyToOne
    private Departamento departamento;

    @Id
    @Column(name = "id_ciudad", length = 15)
    private String id_ciudad;

    @Column(name = "nombre", length = 20)
    private String nombre;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ciudad ciudad = (Ciudad) o;
        return Objects.equals(id_ciudad, ciudad.id_ciudad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_ciudad);
    }
}
