package kr.kh.edu.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.kh.edu.vo.MemberVO;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	// 컨트롤러에서 빠져 나올때 실행 (5번)
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {
		
		// 회원 정보가 있는지 확인 => 컨트롤러가 model에 다음 user 정보가 있는지 확인
		MemberVO user = (MemberVO) modelAndView.getModel().get("user");
		if(user == null) {
			return;
		}
		// 있으면 세션에 저장, 저장한 이름을 잘 기억 => 곳곳에서 사용될 예정. 앞에 "user"가 중요! 
		request.getSession().setAttribute("user", user);
		
	}
}
