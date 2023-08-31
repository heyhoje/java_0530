package kr.kh.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.kh.study.service.MemberService;

@Controller
public class MemberController {

	//@Autowired
	//private MemberService memberService;
	
	// 5.0.6 으로 수정했기 때문에 @GetMapping  쓸 수 있음
	@GetMapping("/member/signup")
	public String memberSignup() {
		return  "member/signup";    // member앞에 슬러시를 치는것도 안치는것의 차이는??? 
	}
//	@RequestMapping(value="/member/signup", method=RequestMethod.GET)
//	public String signup() {
//		int count = memberService.count();
//		System.out.println(count);
//		return "member/signup";		
//	}
	
//	@RequestMapping(value="/member/signup", method=RequestMethod.POST)
//	public String signupPost(MemberVO member, Model model) {
//		System.out.println(member);
//		Message msg = new Message("/member/signup", "회원 가입에 실패했습니다.");
//		
//		if(memberService.signup(member)) {
//			msg = new Massage("/", "회원 가입에 성공했습니다.");
//		}
//		model.addAttribute("msg", msg);
//		return "message";
//	}
}
