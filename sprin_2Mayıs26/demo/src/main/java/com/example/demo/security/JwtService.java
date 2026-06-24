package com.example.demo.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {

    public boolean isTokenValid(
            String token,
            String username
    ) {

        final String extractedUsername =
                extractUsername(token);

        return extractedUsername
                .equals(username);
    }

    public String extractUsername(
            String token
    ) {

        return Jwts.parser()

                .verifyWith(
                        Keys.hmacShaKeyFor(
                                secretKey.getBytes()
                        )
                )

                .build()

                .parseSignedClaims(token)

                .getPayload()

                .getSubject();
    }

    @Value("${app.jwt.secret}")
    private String secretKey;

    public String generateToken(
            String username
    ) {

        return Jwts.builder()

                .setSubject(username)

                .setIssuedAt(new Date())

                .setExpiration(
                        new Date(
                                System.currentTimeMillis()
                                        + 1000 * 60 * 60
                        )
                )

                .signWith(
                        Keys.hmacShaKeyFor(
                                secretKey.getBytes()
                        )
                )

                .compact();
    }
}