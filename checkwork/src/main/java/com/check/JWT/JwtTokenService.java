package com.check.JWT;

import com.check.models.User;
import io.jsonwebtoken.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Log4j2
@Component
public class JwtTokenService {
    private final String SECRET_KEY = "2D4A614E645267556B58703273357638792F423F4428472B4B6250655368566D2D4A614E645267" +
            "556B58703273357638792F423F4428472B4B6250655368566D";
    private final String ISSUER = "20240719";

    public String generateAccessToken(User user) {
        Map<String,String> claims = new HashMap<>();
        claims.put("userId", String.valueOf(user.getId()));
        claims.put("userName", user.getUsername());
        return Jwts.builder()
                .setClaims(claims)
                .setIssuer(ISSUER)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 8 * 60 * 60 * 1000)) // 8 hours
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }
    public Integer getUserId(String token) {
        Claims claims = getClaims(token);
        int userId = (int) claims.get("userId");
        ThreadContext.put("userId", "userId");
        return userId;
    }
    public Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }
    private String getUsernameByToken(String token) {
        Claims claims = getClaims(token);
        String username = (String) claims.get("userName");
        ThreadContext.put("username", "username");
        return username;
    }
    public String getUsername(HttpServletRequest request){
        return getUsernameByToken(
                request
                        .getHeader(HttpHeaders.AUTHORIZATION)
                        .split(" ")[1].trim()
        );
    }
    public boolean validate(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException ex) {
            log.error("Invalid JWT token - {}", ex.getMessage());
        } catch (ExpiredJwtException ex) {
            log.error("Expired JWT token - {}", ex.getMessage());
        } catch (UnsupportedJwtException ex) {
            log.error("Unsupported JWT token - {}", ex.getMessage());
        } catch (IllegalArgumentException ex) {
            log.error("JWT claims string is empty - {}", ex.getMessage());
        }
        return false;
    }
}
