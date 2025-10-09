package com.assignment3.util;

//JwtUtil.java
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class JwtUtil {

 // Generate a secret key for signing the JWT (HS256 algorithm)
 private static final SecretKey SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);

 // Method to generate JWT token with username and roles
 public static String generateToken(String username, List<String> roles) {
     return Jwts.builder()
             .setSubject(username)
             .claim("roles", roles)     // Add "roles" claim
             .setIssuedAt(new Date())
             .setExpiration(new Date(System.currentTimeMillis() + 3600000)) // 1 hour expiration
             .signWith(SECRET_KEY)      // Sign with secret key
             .compact();
 }

 // Method to validate the JWT token and return claims as a Map
 public static Map<String, Object> validateToken(String token) {
     return Jwts.parserBuilder()
             .setSigningKey(SECRET_KEY)
             .build()
             .parseClaimsJws(token)
             .getBody();
 }
}

