package kr.kh.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import kr.kh.study.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("/test")
	public String test() {
		return "redirect:/"; // url을 바꿔서 main페이지로 보내주는것
	}
}
