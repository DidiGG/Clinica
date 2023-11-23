package co.edu.uniquindio.clinica.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientCreateAppointmentRequestDTO {
    @Nullable
    private String appointment_date;
    @Nullable
    private String hour;
    @Nullable
    private String state;
    @Nullable
    private  String reason;
    @NotNull
    private  Integer medicId;
    @Nullable
    private Integer specialization;

}