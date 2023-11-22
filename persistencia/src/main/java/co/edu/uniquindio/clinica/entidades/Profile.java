package co.edu.uniquindio.clinica.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Profile implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name="idNumber", length = 45, nullable = false, unique = true)
    private String idNumber;

    @Column(name="names", length=60,nullable = false)
    private String names;

    @Column(name="last_names", length=60,nullable = false)
    private String lastNames;
    @Column(name="birth_date")
    private LocalDate birth_date;

    @Column(name="phone_number", length=40)
    private Integer phoneNumber;

    @Column(name="deleted_at")
    private LocalDateTime deletedAt;
    @Column(name="gender")
    private String gender;
    @Column(name="consulting_room")
    private String consulting_room;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
    //falta meter al medito el consultorio y las especializaciones
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Profile profile = (Profile) o;

        return Objects.equals(id, profile.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @OneToOne
    private User user;

    @ManyToMany()
    private List<Alergia> alergiaList;
    @ManyToMany()
    private List<Especializacion> especializacionList;

    @OneToMany(mappedBy = "paciente")
    private List<Cita> citaAsPacienteList;

    @OneToMany(mappedBy = "medico")
    private List<Cita> citaAsMedicoList;

    @ManyToOne
    private Eps eps;

}
