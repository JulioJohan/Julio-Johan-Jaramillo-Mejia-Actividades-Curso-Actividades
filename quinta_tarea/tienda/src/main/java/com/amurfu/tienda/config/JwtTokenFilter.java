package com.amurfu.tienda.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;

// Clase para filtrar los tokens JWT en las solicitudes HTTP.
public class JwtTokenFilter extends OncePerRequestFilter {

    // Variable para almacenar la clave secreta usada para verificar el token JWT.
    private String secret;

    // Constructor que inicializa el filtro con una clave secreta.
    public JwtTokenFilter(String secre) {
        this.secret = secre;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // Obtiene el encabezado de autorización de la solicitud HTTP.
        String tokenHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        // Verifica si el encabezado de autorización no es nulo y si comienza con "Bearer ".
        if(tokenHeader != null && tokenHeader.startsWith("Bearer ")){
//            Extraemos el token, ejemplo Bearer jsjajjaskakjsa
//            Toma jsjajjaskakjsa
            String token = tokenHeader.split(" ")[1].trim();

            try {
                // Convierte la clave secreta a bytes usando UTF-8.
                byte[] secretKeyBytes = secret.getBytes(StandardCharsets.UTF_8);

                // Parsea y valida el token JWT.
                //  Con la key que creamos
                Jws<Claims> claims = Jwts.parserBuilder()
                        .setSigningKey(secretKeyBytes)
                        .build()
                        .parseClaimsJws(token);

                // Obtiene el nombre de usuario (subject) del cuerpo del token.
                String username = claims.getBody().getSubject();
                // establece una nueva autenticación con el nombre de usuario.
                if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                    UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                            username, null, Collections.emptyList());

//                    Autentica
                    SecurityContextHolder.getContext().setAuthentication(auth);
                }

            }catch (Exception exception){
                exception.printStackTrace();
                SecurityContextHolder.clearContext();;
            }
        }
        // Continúa con el resto de la cadena de filtros.
        filterChain.doFilter(request, response);

    }
}
