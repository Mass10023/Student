package com.student.Students;

	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RestController;
	import org.springframework.web.bind.annotation.CrossOrigin;
	
	@CrossOrigin
	@RestController
	public class UserController {

	    @PostMapping("/login")
	    public String login(@RequestBody User login) {
	        // Replace this with your actual authentication logic
	        if ("Ali".equals(login.getUsername()) && "123456".equals(login.getPassword())) {
	            return "Successfully logged in!";
	        } else {
	            return "Failed to log in. Invalid username or password.";
	        }
	    }
	}
