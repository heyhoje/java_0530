package kr.kh.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.kh.spring.vo.MemberVO;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	/** 5번에서 가로채서 로그인 유지. 이미 방문해서 나왔기 때문에 return값이 필요없음 */
	public void postHandle( 
		HttpServletRequest request,
		HttpServletResponse respose,
		Object handler,
		ModelAndView mv) {
		
		MemberVO user = (MemberVO)mv.getModel().get("user");
		
		if(user != null ) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
		}
	}
}