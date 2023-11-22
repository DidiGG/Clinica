package co.edu.uniquindio.clinica.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterRequestDTO {

    @NotNull
    private String email;
    @NotNull
    private  String gender;
    @NotNull
    private String rol;
    @NotNull
    private String password;
    @NotNull
    private String idNumber;
    @NotNull
    private String names;
    @NotNull
    private String lastNames;
    @NotNull
    private String phoneNumber;
    @Nullable
    private LocalDate birth;
    @Nullable
    private String consultingRoom;


}
