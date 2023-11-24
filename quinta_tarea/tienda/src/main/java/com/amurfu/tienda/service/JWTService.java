package com.amurfu.tienda.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
@Slf4j
public class JWTService {

    // Inyección del valor de la clave secreta para la firma de tokens JWT. que esta en el properties
    @Value("${jwt.secret}")
    private String secret;

    // Método para generar un token JWT para un email
    public String generateToken(String email){
        // Tiempo de expiración del token en milisegundos (1 hora en este caso).
        long expirationTimeInMillis = 3600000;
        // Convierte la clave secreta en bytes usando UTF-8.
        byte[] secretKeyBytes = secret.getBytes(StandardCharsets.UTF_8);


        SecretKey secretKey = Keys.hmacShaKeyFor(secretKeyBytes);


        return Jwts.builder()
                .setSubject(email) //Establece el correo como sujeto del token
                .setIssuedAt(new Date())  // Establece la fecha y hora de emisión del token.
                // Establece la fecha y hora de expiración del token (actual + tiempo de expiración).
                .setExpiration(new Date(System.currentTimeMillis() + expirationTimeInMillis))
                // Firma el token con el algoritmo HS512 y la clave secreta.
                .signWith(secretKey,SignatureAlgorithm.HS512)
                .compact();

    }



}
