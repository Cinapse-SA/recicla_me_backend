package ao.cinapse.recicla_me.core.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

public class JwtUtil
{
    private static final String SECRET = "3cfa76ef14937c1c0ea519f8fc057a80fcd04a7420f8e8bcd0a7567c272e007b";
    private static final long EXPIRATION_TIME = 864_000_000;

    public static String gerarToken( String username ) {
        return Jwts.builder()
                .setSubject( username )
                .setExpiration( new Date(System.currentTimeMillis() + EXPIRATION_TIME) )
                .signWith(getSigningKey(), SignatureAlgorithm.HS512)
                .compact();
    }

    public static Key getSigningKey() {
        byte[] keyBytes = SECRET.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
