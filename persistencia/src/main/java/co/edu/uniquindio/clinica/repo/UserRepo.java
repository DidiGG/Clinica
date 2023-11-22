package co.edu.uniquindio.clinica.repo;

import co.edu.uniquindio.clinica.entidades.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    Optional<User> findByEmailAndPassword(String email, String password);

    Optional<User> findByEmail(String email);

    Page<User> findAll(Pageable pageable);
    Integer countByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.profile.idNumber = :idNumber")
    Optional<User> findByIdNumber(@Param("idNumber") String idNumber);


   // @Query("SELECT u From User u WHERE u.profile.idNumber = :idNumber AND u.password = :password")
    // Optional<User> findByidNumberAndPassword(@Param("idNumber")String idNumber,@Param("password") String password);




}