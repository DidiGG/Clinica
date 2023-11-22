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
public class Departamento implements Serializable {
    @OneToMany(mappedBy = "departamento")
    private List<Ciudad> ciudades;

    @Id
    @Column(name = "id_departamento", length = 15)
    private String id_departamento;

    @Column(name = "nombre", unique = true, updatable = true, length = 20)
    private String nombre;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Departamento that = (Departamento) o;
        return Objects.equals(id_departamento, that.id_departamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_departamento);
    }

}
