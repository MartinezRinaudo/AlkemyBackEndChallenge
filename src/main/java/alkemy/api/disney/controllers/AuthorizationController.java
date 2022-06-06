package alkemy.api.disney.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import alkemy.api.disney.models.UserModel;
import alkemy.api.disney.services.AuthorizationService;

@RestController
@RequestMapping("/auth")
public class AuthorizationController {

	@Autowired
	AuthorizationService userServ;
	
	@PostMapping(path = "/login")
	ResponseEntity<?> login(@RequestBody UserModel user) throws IOException {
		return new ResponseEntity<>(userServ.getUser(user), HttpStatus.OK);
	}
	
	@PostMapping(path = "/signup")
	ResponseEntity<?> signup(@RequestBody UserModel user) throws IOException {
		return new ResponseEntity<>(userServ.postUser(user), HttpStatus.CREATED);
	}
}
