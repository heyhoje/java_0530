package kr.kh.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.kh.home.service.MemberService;
import kr.kh.home.vo.MemberVO;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;

	@GetMapping("/member/signup")
	public String memberSignup() {
		return "/member/signup"; // .root 레이아웃을 적용할 수 있도록 /member로 바꿈 (/*/*양식)
	}
	
	@PostMapping("/member/signup") //@requestMapping(value="/member/signup", method=requestMethod.POST)
	public String memberSignupPost(Model model, MemberVO member) {
		if(memberService.signup(member)) {
			msg = "회원가입 성공!";
			url = "/";
		}else {
			msg = "회원가입 실패ㅠ";
			url = "/member/signup";
		}
		
		// 얘네를 추가해야 뭐가 된다고???????
		model.addAttribute("url", url);
		model.addAttribute("msg", msg);
		return "util/message";
	}
	
	@GetMapping("/member/login")
	public String memberLogin() {
		return "/member/login";
	}
	
	@PostMapping("/member/login")
	public String memberLoginPost(Model model, MemberVO member) {//Model 은 서버에서 화면으로 보내기 위해 프로그램에서 제공하는 클래스
		String msg, url;
		System.out.println(member); // 화면 -> 서버 로 잘 넘어오는지 확인.... 난 못함. 나한테 왜그러냐......
//		MemberVO user = memberService.login(member);
//		
//		if(user != null) {
//			msg = "로그인 성공!";
//			url = "/"; // 메인 홈으로 ㄱ
//		}else {
//			msg = "로그인 실패ㅠ";
//			url = "/member/login"; // 다시 로그인 페이지로 ㄱ 
//		}
//		
//		// 얘네를 추가해야 뭐가 된다고???????
//		model.addAttribute("url", url);
//		model.addAttribute("msg", msg); 
//		model.addAttribute("user", user);
		
		return "util/message"; //(o)
	}
	@GetMapping("/member/logout")
	public String memberLogout(Model model) {
		
		return "/util/message";
	}
}
