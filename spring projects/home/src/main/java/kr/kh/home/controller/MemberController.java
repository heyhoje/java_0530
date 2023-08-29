package kr.kh.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import kr.kh.home.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;

}
