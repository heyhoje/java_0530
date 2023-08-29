package kr.kh.end.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.kh.end.service.EndService;

@Controller
public class EndController {

	@Autowired
	private EndService endService;
	
	@GetMapping("/test")
	public String test() {
		int count = endService.count();
		System.out.println(count);
		return "redirect:/";
		
	}
}
