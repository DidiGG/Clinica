package co.edu.uniquindio.clinica.servicios;

import co.edu.uniquindio.clinica.dto.*;
import co.edu.uniquindio.clinica.entidades.User;

import java.util.List;

public interface UserService {

    Boolean registerUserPatient(UserRegisterRequestDTO newUserInfo) throws Exception;
    Boolean registerUserMedic(UserRegisterRequestDTO newUserInfo) throws Exception;
    List<MedicAppointmentDTO> getAllMedicAppointmentsByEmail(String email) throws Exception;

    List<PatientAppointmentDTO> getAllPatientAppointmentsByEmail(String email) throws Exception;


    User updateUser(User u) throws Exception;

    void deleteUser(int id)throws Exception;
    void validateUserRegisterDTO(UserRegisterRequestDTO user) throws Exception;
    List<User> listUsers() throws Exception;

    LoginResponseDTO login(LoginRequestDTO loginInfo) throws Exception;

    void createPatientAppointment(PatientCreateAppointmentRequestDTO appointmentInfo, String email)throws Exception;
}
