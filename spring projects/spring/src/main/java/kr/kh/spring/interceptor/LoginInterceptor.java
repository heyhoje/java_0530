package kr.kh.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.kh.spring.vo.MemberVO;

public class LoginInterceptor extends HandlerInterceptorAdapter{
// 컨트롤러에 데이터가 들어가기 전 prehandle / 컨트롤러에서 나올때 가로챔 posthandle
	
	@Override
	public void postHandle(
			HttpServletRequest request,
			HttpServletResponse response,
			Object handler,
			ModelAndView mv) {
		
		MemberVO user = (MemberVO)mv.getModel().get("user"); // 저장된 정보를 가져오고, MemberVO로 형변환해줌
		
		if(user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			
		}
		
	}
}
