package co.edu.uniquindio.clinica.controllers;

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

@RestController
@AllArgsConstructor
@RequestMapping("api/user")
@CrossOrigin
public class UserController {

    private final UserServiceImpl userServiceImpl;
    //private final MicroSiteServiceImpl micrositeServiceImpl;


    @PostMapping("/register")
    public ResponseEntity<MessageDTO> register(@Valid @RequestBody UserRegisterRequestDTO userInfo)  throws Exception{
        try{
            if(userInfo.getRol().equalsIgnoreCase("PACIENTE")){
                userServiceImpl.registerUserPatient(userInfo);
                return ResponseEntity.status(200).body( new MessageDTO(HttpStatus.OK, true,"Paciente registrado exitosamente",null ));

            }else{
                userServiceImpl.registerUserMedic(userInfo);
                return ResponseEntity.status(200).body( new MessageDTO(HttpStatus.OK, true,"Medico registrado exitosamente",null ));

            }
        } catch (Exception e) {
            return ResponseEntity.status(200).body( new MessageDTO(HttpStatus.OK, false,"Ocurrió un error\n"+e.getMessage(),null ));
        }
    }

}
