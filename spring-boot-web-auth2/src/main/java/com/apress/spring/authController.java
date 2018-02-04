package com.apress.spring;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class authController {
	@RequestMapping("/")
	public String index(Principal principal) {
			return "index";
	}
}
