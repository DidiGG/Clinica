package co.edu.uniquindio.clinica.repo;

import co.edu.uniquindio.clinica.entidades.Alergia;
import co.edu.uniquindio.clinica.entidades.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AllergyRepo extends JpaRepository<Alergia, Integer> {

    Optional<Alergia> findById(Integer idNumber);

}
