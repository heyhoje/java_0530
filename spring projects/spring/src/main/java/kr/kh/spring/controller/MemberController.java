package kr.kh.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.kh.spring.service.MemberService;
import kr.kh.spring.vo.MemberVO;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="/member/signup", method=RequestMethod.GET)
	public String signup() {
		int count = memberService.count();
		System.out.println(count);
		return "member/signup";
	}
	
	@RequestMapping(value="/member/signup", method=RequestMethod.POST)
	public String signupPost(MemberVO member, Model model) {
//		System.out.println("아이디 : " + me_id);
//		System.out.println("비번 : " + me_pw);
//		System.out.println("이메일 : " + me_email);
		// System.out.println(member);
		String msg = "회원 가입에 실패했습니다.";
		String url = "/member/signup";
		if(memberService.signup(member)) {
			msg = "회원 가입에 성공했습니다.";
			url = "/";
		}
		model.addAttribute("msg", msg);
		model.addAttribute("url", url); // 메인페이지로 ㄱㄱ
		return "message";
	}
	
	@GetMapping(value="/member/login")
	public String memberLogin() {
		return "member/login";
	}
	
	@PostMapping(value="/member/login")
	public String memberLoginPost(MemberVO member) {
		String msg = "로그인에 실패했습니다.";
		String url = "/member/login";
		
		MemberVO user = memberService.login(member);
		if(user != null) {
			msg = "로그인에 성공했습니다.";
			url = "/";
		}
		model.addAttribute("url", url);
		model.addAttribute("msg", msg);
		return "message";
	}

}
