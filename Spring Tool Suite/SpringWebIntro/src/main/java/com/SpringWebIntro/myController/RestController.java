package com.SpringWebIntro.myController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("rc1")
public class RestController {
	
	@GetMapping("/hello")
	public String doThis() {
		return "RestPage";
	}
}
