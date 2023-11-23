package co.edu.uniquindio.clinica.repo;

import co.edu.uniquindio.clinica.entidades.Alergia;
import co.edu.uniquindio.clinica.entidades.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppointmentRepo extends JpaRepository<Cita, Integer> {

    Optional<Cita> findById(Integer id);

}
