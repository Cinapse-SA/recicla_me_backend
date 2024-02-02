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

    public String gerarToken(Usuario usuario) {
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

    private String gerarToken(HashMap<String, Object> extraClaims, UserDetails userDetails)
    {
        return buildToken(extraClaims, userDetails, Long.parseLong(expirationTime));
    }

    private String buildToken(HashMap<String, Object> extraClaims, UserDetails userDetails, long expirationTime) {
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
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
}
