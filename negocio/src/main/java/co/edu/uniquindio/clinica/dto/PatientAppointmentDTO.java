package co.edu.uniquindio.clinica.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientAppointmentDTO {
    @NotNull
    private String especialization;
    @NotNull
    private  String medicName;
    @NotNull
    private  String consultingRoom;
    @NotNull
    private String epsName;
    @NotNull
    private CitaBasicInfo appointmentInfo;
}
