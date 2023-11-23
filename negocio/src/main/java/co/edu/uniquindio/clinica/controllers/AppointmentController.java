package co.edu.uniquindio.clinica.controllers;

import co.edu.uniquindio.clinica.dto.MedicAppointmentDTO;
import co.edu.uniquindio.clinica.dto.MessageDTO;
import co.edu.uniquindio.clinica.dto.UserRegisterRequestDTO;
import co.edu.uniquindio.clinica.security.TokenUtils;
import co.edu.uniquindio.clinica.servicios.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/appointment")
@CrossOrigin
public class AppointmentController {

    private final UserServiceImpl userServiceImpl;
    //private final MicroSiteServiceImpl micrositeServiceImpl;


    @GetMapping("/getAll")
    public ResponseEntity<MessageDTO> getAllBill(HttpServletRequest request)  throws Exception{
        try{
            String authorizationHeader = request.getHeader("Authorization");

            String jwtToken = authorizationHeader.substring(7); // eliminamos el prefijo "Bearer "

            String email = TokenUtils.getEmailFromJWTToken(jwtToken);
            List<MedicAppointmentDTO> citaList = userServiceImpl.getAllMedicAppointmentsByEmail(email);

            return ResponseEntity.status(200).body( new MessageDTO(HttpStatus.OK, true,"Obtencion de citas completa",citaList ));

        } catch (Exception e) {
            return ResponseEntity.status(200).body( new MessageDTO(HttpStatus.OK, false,"Ocurrió un error",e.getMessage() ));
        }
    }

}
