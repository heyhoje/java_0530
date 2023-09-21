package kr.kh.edu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.kh.edu.service.MemberService;
import kr.kh.edu.vo.MemberVO;

@Controller
public class MemberController {

	@Autowired
	MemberService memberService;
	
	
	@GetMapping("/member/signup")
	public String signup(Model model) {
		
		model.addAttribute("title", "서버 to 화면 인사해");
		model.addAttribute("line", "--------------------------------------");
		return "/member/signup";
	}
	
//	/** 서블릿에서 인사 콘솔창으로 받아오던거 스프링에서 하려면 어떻게해? */
//	@GetMapping("/member/signup")
//	public String text(Model model, String test) {
//		
//		System.out.println("내가 하고 싶은 말은 : " + test);
//		return "member/signup";
//	}
	

	@PostMapping("/member/signup")
	public String signupPost(MemberVO member, Model model) {
//		System.out.println(me_id);
//		System.out.println(me_pw);
		System.out.println(member);
		
		// 서비스에게 회원가입 시켜야 함 => 회원정보를 주면서! + => 이미 가입되있는지 아닌지 모름/리턴값으로 가입여부를 알려달라고 함
		// 화면에서 안들어오는게 맞지만 서버에서 재가공, 추가 정보가 필요할 경우
		// member.setMe_session_id();
		// 이 정보로 일을 다 할 수있는지 확인. 프로젝트할때 주석을 많이 달아주는게 중요(나를 위해)
		boolean res = memberService.signup(member);
		
		if(res) {
			model.addAttribute("msg", "회원가입 성공!");
			model.addAttribute("url", "");
		}
		else {
			model.addAttribute("msg", "회원가입 실패!");
			model.addAttribute("url", "member/signup");
		}
		return "/main/message";
	}
	
	// 아이디 중복 체크
	@ResponseBody
	@PostMapping("/member/id/check")
	public boolean ajaxTest3(@RequestParam("id") String id){
//		System.out.println("/member/id/check : " + id);
//		return true;
		return memberService.checkId(id);
	}
	
	// 로그인 -> 화면에 연결 login.jsp만들러 ㄱㄱ
	@GetMapping("/member/login")
	public String login() {
		return "/member/login";
	}
	
	@PostMapping("/member/login")
	public String loginPost(Model model, MemberVO member) {
		// 화면에서 보내온 아이디와 비번을 가져와서 확인
		System.out.println(member);
		
		// 입력받은 회원 정보와 일치하는 회원정보가 있으면 가져오라고 요청!
		MemberVO user = memberService.login(member);
		// 가져왔으면(로그인 성공하면)
		if(user != null) {
			model.addAttribute("user", user);
			model.addAttribute("url", "");
			model.addAttribute("msg", "로그인 성공!");
		}
		else {
			model.addAttribute("url", "member/login");
			model.addAttribute("msg", "로그인 실패!");
		}
		return "/main/message";
	}
	
	// 로그아웃
	@GetMapping("/member/logout")
	public String logout(Model model, HttpSession session) {
		
		session.removeAttribute("user");
		
		model.addAttribute("msg", "로그아웃 성공!");
		model.addAttribute("url", "");
		return "/main/message";
	}
}
