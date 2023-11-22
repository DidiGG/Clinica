package co.edu.uniquindio.clinica.entidades;

import lombok.*;
import javax.persistence.Id;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Pqrs implements Serializable {

    @OneToOne(mappedBy = "pqrs")
    private Action accion;

    @ManyToOne
    private Profile admin;

    @ManyToOne
    private Cita cita;

    @ManyToOne
    private Profile medico;

    @Id
    @Column(name = "radicado", length = 15)
    private String radicado;

    @Column(name = "titulo", length = 30)
    private String titulo;

    @Column(name = "contenido", length = 100)
    private String contenido;

    @Column(name = "fecha_creacion", length = 15)
    private String fecha_creacion;


    @Column(name = "respuesta_peticion", length = 100)
    private String respuesta_peticion;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pqrs pqrs = (Pqrs) o;
        return Objects.equals(radicado, pqrs.radicado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(radicado);
    }
}
