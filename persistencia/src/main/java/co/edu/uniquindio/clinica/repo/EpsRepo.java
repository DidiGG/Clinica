package co.edu.uniquindio.clinica.repo;

import co.edu.uniquindio.clinica.entidades.Alergia;
import co.edu.uniquindio.clinica.entidades.Eps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EpsRepo extends JpaRepository<Eps, Integer> {

    Optional<Eps> findById(Integer id);

}
