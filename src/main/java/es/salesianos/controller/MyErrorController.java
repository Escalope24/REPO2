package es.salesianos.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class MyErrorController {
	@RequestMapping("/error")
	  public String handleError() {
		return "error";
		
	}
	
	public String getErrorPath() {
		return "/error";
	}
}
