package com.SpringBootJWT.util;

import java.security.Key;
import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class JwtUtil {
	
	
	private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	
	//generate token 
	
	public static String generateToken(String username) {
		return Jwts.builder()
				.setSubject(username)
				.setIssuer("MyApp")
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis()+10000000))
				.signWith(key)
				.compact();
	}
	
	
	//validate Token
	public static String validateToken(String Token) {
		return Jwts.parserBuilder()
				.setSigningKey(key)
				.build()
				.parseClaimsJws(Token)
				.getBody()
				.getSubject();
	}
}
