package co.edu.uniquindio.clinica.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientBasicInfoDTO {

    @NotNull
    private String name;
    @NotNull
    private  String gender;
    @Nullable
    private List<String> alergiesNames;



}
