package co.edu.uniquindio.clinica.exceptions;

import co.edu.uniquindio.clinica.dto.MessageDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAuthenticationEntryPointException implements AuthenticationEntryPoint {
    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {


        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");

        MessageDTO<String> responseContent = new MessageDTO<>(HttpStatus.FORBIDDEN,false,"Autenticación fallida :"+ authException.getMessage(),null);
        response.getWriter().write(objectMapper.writeValueAsString(responseContent));
    }
}