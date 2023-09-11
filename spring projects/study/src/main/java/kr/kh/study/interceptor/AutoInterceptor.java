package kr.kh.study.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import kr.kh.study.service.MemberService;
import kr.kh.study.vo.MemberVO;

public class AutoInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	MemberService memberService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler) throws Exception {
		// 이미 로그인되어 있으면 건너뜀
		HttpSession session = request.getSession();
		// 클래스형변환에서/ 부모클래스 객체(Object)를 자식 클래스(MemberVO) 객체로 형번환
		MemberVO user = (MemberVO) session.getAttribute("user");
		
		if(user != null) {
			return true;
		}
		// 로그인 되어 있지 않으면 쿠키가 있는지 확인 
		Cookie cookie = WebUtils.getCookie(request, "loginCookie");
		// 쿠키가 없으면 건너뜀(자동로그인 x)
		if(cookie == null) {
			return true;
		}
		user = memberService.getMemberBySession(cookie.session.getId());
		if(user != null ) {
			session.setAttribute("user", user);
		}
		return true;
	}
}