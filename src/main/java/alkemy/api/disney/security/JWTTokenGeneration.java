package alkemy.api.disney.security;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import alkemy.api.disney.models.UserModel;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTTokenGeneration implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Value("${JWT.secret}")
	private String secret;
	
	public String getUsernameFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}
	
	public <T> T getClaimFromToken(String token, Function<Claims, T> claimResolve) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimResolve.apply(claims);
	}
	
	public Claims getAllClaimsFromToken(String token) {
		return Jwts
				.parser()
				.setSigningKey(secret)
				.parseClaimsJws(token)
				.getBody();
	}
	
	/*TOKEN GENERATION*/
	
	public String generateToken(UserModel user) {
		Map<String, Object>claims = new HashMap<>();
		return generateJWTToken(claims, user.getUserName());
	}
	
	public String generateJWTToken(Map<String, Object> claims, String subject) {
		return Jwts
				.builder()
				.setClaims(claims)
				.setSubject(subject)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 5 * 60 * 60 * 1000))
				.signWith(SignatureAlgorithm.HS512, secret)
				.compact();
	}
}
