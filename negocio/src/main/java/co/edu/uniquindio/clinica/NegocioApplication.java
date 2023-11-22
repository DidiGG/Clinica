package co.edu.uniquindio.clinica;

import co.edu.uniquindio.clinica.exceptions.CustomAccessDeniedHandlerException;
import co.edu.uniquindio.clinica.exceptions.CustomAuthenticationEntryPointException;
import co.edu.uniquindio.clinica.security.CorsConfig;
import co.edu.uniquindio.clinica.security.JWTAuthorizationFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@SpringBootApplication

@Import(CorsConfig.class)
public class NegocioApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {

        SpringApplication.run(PersistenciaApplication.class, args);

    }

    @EnableWebSecurity
    @EnableGlobalMethodSecurity(prePostEnabled = true)

    @Configuration
    class WebSecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.cors();
            http.csrf().disable()
                    .addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
                    .authorizeRequests()

                    .antMatchers(HttpMethod.POST, "/api/auth/login").permitAll()
                    .antMatchers(HttpMethod.POST, "/api/auth/test").permitAll()
                    .antMatchers(HttpMethod.POST, "/api/user/register").permitAll()
                    .antMatchers(HttpMethod.GET, "/api/product/search/{pattern}").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .exceptionHandling().accessDeniedHandler(new CustomAccessDeniedHandlerException())
                    .authenticationEntryPoint(new CustomAuthenticationEntryPointException());;
        }
        protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
            return application.sources(NegocioApplication.class);
        }
    }
}