package com.amurfu.tienda.config;

import com.amurfu.tienda.config.JwtTokenFilter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // Bean para configurar la cadena de filtros de seguridad.
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity,JwtTokenFilter jwtTokenFilter) throws Exception{
        // Desactiva CSRF (Cross-Site Request Forgery). Útil para APIs REST que no usan cookies.
        httpSecurity.csrf(AbstractHttpConfigurer::disable)
                // Configura la gestión de sesiones para que sea sin estado.
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                // Configura las reglas de autorización de solicitudes HTTP.
                .authorizeHttpRequests(request -> request
                        // Permite todas las solicitudes a "/auth/login" sin autenticación.
                        .requestMatchers("/authenticacion/login").permitAll()
                        .requestMatchers("/user/save_user").permitAll()
                        // Todas las demás solicitudes requieren autenticación.
                        .anyRequest().authenticated()
                )
                // Agrega el filtro JwtTokenFilter antes del filtro de autenticación por usuario y contraseña.
                .addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
        // Construye y devuelve la cadena de filtros de seguridad configurada.
        return httpSecurity.build();
    }

    // Bean para crear una instancia de JwtTokenFilter.
    @Bean
    public JwtTokenFilter jwtTokenFilter(@Value("${jwt.secret}")String secret){
        // Inyecta la clave secreta (definida en las propiedades de la aplicación) en el filtro JWT.
        return new JwtTokenFilter(secret);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


}
