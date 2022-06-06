package alkemy.api.disney.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration {

	@Autowired
	JWTAuthenticationEntryPoint JWTAuthEP;
	
	@Autowired
	JWTReqFilter jwtReqFilter;
	
	@Bean
	public PasswordEncoder  passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeHttpRequests().anyRequest().permitAll()
			.and().exceptionHandling().authenticationEntryPoint(JWTAuthEP)
			.and().addFilterBefore(jwtReqFilter, UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}
}
