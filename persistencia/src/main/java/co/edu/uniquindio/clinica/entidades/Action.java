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
public class Action implements Serializable {

    @OneToOne
    private Pqrs pqrs;

    @Id
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private int id_accion;

    @Column(name = "respuesta_peticion", length = 30)
    private String respuesta_peticion;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Action accion = (Action) o;
        return Objects.equals(id_accion, accion.id_accion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_accion);
    }
}
