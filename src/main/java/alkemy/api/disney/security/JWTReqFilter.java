package alkemy.api.disney.security;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JWTReqFilter extends OncePerRequestFilter {
	@Autowired
	JWTTokenGeneration jwt;
	
	protected void doFilterInternal(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, javax.servlet.FilterChain filterChain) throws javax.servlet.ServletException ,java.io.IOException {
		if(request.getRequestURI().equals("/auth/login")) {
			filterChain.doFilter(request, response);
		} else if (request.getRequestURI().equals("/auth/signup")) {
			filterChain.doFilter(request, response);
		} else {
			String header = request.getHeader("Authorization");
			try {
				jwt.getUsernameFromToken(header);
			} catch (Exception e){
				System.out.println(e.getMessage());
				response.setStatus(HttpServletResponse.SC_FORBIDDEN);
				response.sendError(HttpServletResponse.SC_FORBIDDEN, "Invalid Credentials");
			}
			filterChain.doFilter(request, response);
		}
	};
}
