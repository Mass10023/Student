package com.student.Students;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping("/get")
	public String index(@RequestParam(value = "data") String data) {
		System.out.println(data);
		return "Greetings from Spring Boot!";
	}
		
		@PostMapping("/post")
	    public String post() {
	        return "POST request received!";
	    }

	    @PutMapping("/put")
	    public String put() {
	        return "PUT request received!";
	    }

	    @DeleteMapping("/delete")
	    public String delete() {
	        return "DELETE request received!";
	    }

	    @PatchMapping("/patch")
	    public String patch() {
	        return "PATCH request received!";
	    }

	    @RequestMapping(value = "/head", method = RequestMethod.HEAD)
	    public String head() {
	        return "HEAD request received!";
	    }

	    @RequestMapping(value = "/options", method = RequestMethod.OPTIONS)
	    public String options() {
	        return "OPTIONS request received!";
	    }
	}