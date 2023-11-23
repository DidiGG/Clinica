package co.edu.uniquindio.clinica.repo;

import co.edu.uniquindio.clinica.entidades.Cita;
import co.edu.uniquindio.clinica.entidades.Especializacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpecializationRepo extends JpaRepository<Especializacion, Integer> {

    Optional<Especializacion> findById(Integer id);

}
