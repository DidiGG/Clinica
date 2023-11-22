package co.edu.uniquindio.clinica.exceptions;

import co.edu.uniquindio.clinica.dto.MessageDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@ControllerAdvice
public class CustomAccessDeniedHandlerException implements org.springframework.security.web.access.AccessDeniedHandler {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");

        MessageDTO<String> responseContent = new MessageDTO<>(HttpStatus.FORBIDDEN,false,"Autenticación fallida :"+ e.getMessage(),null);
        response.getWriter().write(objectMapper.writeValueAsString(responseContent));

    }
}
