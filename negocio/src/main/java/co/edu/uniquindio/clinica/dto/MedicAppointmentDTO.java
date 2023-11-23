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
public class MedicAppointmentDTO {
    @NotNull
    private String especialization;
    @NotNull
    private  ClientBasicInfoDTO patientInfo;
    @NotNull
    private String epsName;
    @NotNull
    private CitaBasicInfo appointmentInfo;
}
