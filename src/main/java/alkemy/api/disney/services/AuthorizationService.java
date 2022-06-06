package alkemy.api.disney.services;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import alkemy.api.disney.models.UserModel;
import alkemy.api.disney.repositories.UserDAO;
import alkemy.api.disney.security.JWTTokenGeneration;

@Service
public class AuthorizationService {

	@Autowired
	UserDAO usDAO;

	@Autowired
	JWTTokenGeneration jwtToken;

	/*
	 * public String createUser(UserModel user) throws IOException { return
	 * usDAOImp.postUser(user); }
	 * 
	 * public String loginUser(UserModel user) throws IOException { return
	 * usDAOImp.getUser(user); }
	 * 
	 */
	public String getUser(UserModel user) throws IOException {
		UserModel userDB = usDAO.findByUserName(user.getUserName());

		if (userDB != null && userDB.getPassword().equals(user.getPassword())) {
			String token = jwtToken.generateToken(user);
			return token;
		} else {
			HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
					.getResponse();
			response.sendError(HttpStatus.UNAUTHORIZED.value(), "Invalid Credentials");
			return "Exception in course...";
		}
	}

	public String postUser(UserModel user) throws IOException {
		UserModel userDB = usDAO.findByUserName(user.getUserName());
		if (userDB != null) {
			HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
					.getResponse();
			response.sendError(HttpStatus.BAD_REQUEST.value(), "This user already exists.");
			return null;
		} else {
			String token = jwtToken.generateToken(user);
			usDAO.save(user);
			return token;
		}
	}
}
