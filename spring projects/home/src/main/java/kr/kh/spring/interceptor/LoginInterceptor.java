package kr.kh.spring.interceptor;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.kh.spring.service.MemberService;
import kr.kh.spring.vo.MemberVO;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	MemberService memberService;
	
	@Override
	/** 5번에서 가로채서 로그인 유지. 이미 방문해서 나왔기 때문에 return값이 필요없음 */
	public void postHandle( 
		HttpServletRequest request,
		HttpServletResponse response,
		Object handler,
		ModelAndView mv) {
		
		MemberVO user = (MemberVO)mv.getModel().get("user");
		
		if(user != null ) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			
			// 자동로그인을 체크한 경우, 쿠키를 생성해서 전달
			if(user.isAutoLogin()) {
				// 쿠키를 생성해서 필요한 정보를 넣고, 클라이언트한테 전달
				Cookie cookie = new Cookie("loginCookie", session.getId());
				cookie.setPath("/");
				
				int day = 7;
				int time = 60 * 60 * 24 * day; // 초.분.하루 하루를 초로 나타낸 결과에 날짜 = 해당하는 일에 대한 초!
				cookie.setMaxAge(time);
				response.addCookie(cookie);
				
				// 쿠키에 넣은 필요한 정보를 DB(회원테이블)에도 추가
				user.setMe_session_id(session.getId()); // 동일한 값을 각자 저장. 하나는 세션, 하나는 쿠키
				Date date = new Date(System.currentTimeMillis()+ time * 1000);
				user.setMe_session_limit(date);
				memberService.updateMemberSession(user);
			}
		}
	}
}