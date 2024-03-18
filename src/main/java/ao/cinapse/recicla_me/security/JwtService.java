package ao.cinapse.recicla_me.security;

import ao.cinapse.recicla_me.models.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;

import static ao.cinapse.recicla_me.utils.JwtUtil.getSigningKey;

@Service
public class JwtService
{
    @Value("${security.jwt.secret-key}")
    private String secretKey;

    @Value("${security.jwt.expiration-time}")
    private String expirationTime;

    public String extractUsername ( String token ) {
        return extractClaim(token, Claims::getSubject);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver ) {
        final Claims claims = extractAllClaims( token );
        return claimsResolver.apply( claims );
    }

    public String gerarToken(Usuario usuario) throws ParseException {
        HashMap<String, Object> claims = new HashMap<>();
        claims.put("idUsuario", usuario.getIdUsuario());
        claims.put("username", usuario.getUsername());
        claims.put("email", usuario.getEmail());
        claims.put("telefone", usuario.getTelefone());

        claims.put("idPessoa", usuario.getIdPessoa().getIdPessoa());
        claims.put("nome", usuario.getIdPessoa().getNome());
        claims.put("nif", usuario.getIdPessoa().getNif());

        claims.put("idTipoPessoa", usuario.getIdTipoUsuario().getIdTipoUsuario());
        claims.put("tipoUsuario", usuario.getIdTipoUsuario().getCodigo());
        return gerarToken(claims, usuario);
    }

    private String gerarToken(HashMap<String, Object> extraClaims, UserDetails userDetails) throws ParseException {
        return buildToken(extraClaims, userDetails, Long.parseLong(expirationTime));
    }

    private String buildToken(HashMap<String, Object> extraClaims, UserDetails userDetails, long expirationTime) throws ParseException {
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt( asDate(LocalDate.now() ) )
                .setExpiration( asDate(LocalDate.now().plusDays(10L)) )
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey( getSigningKey() )
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode( secretKey );
        return Keys.hmacShaKeyFor( keyBytes );
    }


    public long getExpirationTime() {
        return Long.parseLong(this.expirationTime)+System.currentTimeMillis();
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }





    public Date asDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    public Date asDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public LocalDate asLocalDate(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public LocalDateTime asLocalDateTime(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}
