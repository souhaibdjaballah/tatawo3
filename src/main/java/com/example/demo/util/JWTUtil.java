package com.example.demo.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
public class JWTUtil {

    private static String SECRET_KEY = "secret";

//    public String extractUsername(String token){}
//
//    public Date extractExpiration(String token){}
//
//    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver){}
//
//    private Claims extractAllClaims(String token){}
//    private Boolean isTokenExpired(String token){}

    public static String generateToken(String username, Date expiryTime){
        String token = JWT.create()
                .withSubject(username)
                .withExpiresAt(expiryTime)
                .sign(Algorithm.HMAC256(SECRET_KEY.getBytes()));
        return token;
    }

    public static String generateToken(String username, List<String> authorities, Date expiryTime, HttpServletRequest request){
        String token = JWT.create()
                .withSubject(username)
                .withExpiresAt(expiryTime)
                .withIssuer(request.getRequestURL().toString())
                .withClaim("roles", authorities)
                .sign(Algorithm.HMAC256(SECRET_KEY.getBytes()));
        return token;
    }

    public static String generateRefreshToken(UserDetails user, Date expiryTime, HttpServletRequest request){
        String token = JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(expiryTime)
                .withIssuer(request.getRequestURL().toString())
                .sign(Algorithm.HMAC256(SECRET_KEY.getBytes()));
        return token;
    }

//    public Boolean validateToken(String token, UserDetails userDetails){
//        final String username = extractUsername(token);
//        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
//    }

}
