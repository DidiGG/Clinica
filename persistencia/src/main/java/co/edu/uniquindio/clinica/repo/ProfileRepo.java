package co.edu.uniquindio.clinica.repo;

import co.edu.uniquindio.clinica.entidades.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepo extends JpaRepository<Profile, Integer> {

    Optional<Profile> findByIdNumber(String idNumber);
    Page<Profile> findAll(Pageable pageable);
    Integer countProfileByIdNumber(String idNumber);
}
