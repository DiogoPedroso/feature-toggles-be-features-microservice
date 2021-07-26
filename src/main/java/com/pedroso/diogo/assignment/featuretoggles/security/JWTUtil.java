package com.pedroso.diogo.assignment.featuretoggles.security;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JWTUtil {
    @Value("${app.security.jwt.secret}")
    private String SECRET_KEY;
    
    @Value("${app.security.jwt.expiration-time-ms}")
    private int jwtExpirationMs;

    public String extractUsername(String token) {
        final String username = extractAllClaims(token).getSubject();
        return username;
    }

    public Date extractExpiration(String token) {
        final Date expiresOn = extractAllClaims(token).getExpiration();
        return expiresOn;
    }

    public Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        return !isTokenExpired(token);
    }
}