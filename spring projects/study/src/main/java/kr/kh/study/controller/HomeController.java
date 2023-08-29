package kr.kh.study.controller;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
		
	@RequestMapping(value = "/")
	public String home(Model model) {
		model.addAttribute("name", "abc"); //*
		return "home";
	}
	
}
