package co.edu.uniquindio.clinica.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CitaBasicInfo {

    @Nullable
    private String created_at;
    @Nullable
    private String appointment_date;
    @Nullable
    private String hour;
    @Nullable
    private String state;
    @Nullable
    private  String reason;

}
