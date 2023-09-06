package kr.kh.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.kh.spring.vo.MemberVO;

public class GuestInterceptor extends HandlerInterceptorAdapter {

	/**3번에서 가로챔. 게시글 등록/수정/삭제
	 * 컨트롤러로 들어가기 전, return true면 원래가려던 url로 돌아가서 이어서 작업
	 * return false 원래 가려던 url로 가지않고 종료함*/
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler)
			throws Exception {
		// 세션에 회원 정보가 없으면(로그인 안했으면) 메인페이지로 이동
		// 있는지 없는지만 확인 하기 때문에 (MemberVO) 클래스 형변환 하지 않아도 됨
		Object user = request.getSession().getAttribute("user"); 
		// MemberVO user = request.getSession().getAttribute("user");
		
		// 로그인 하지 않았으면
		if(user != null) {
			// 메인페이지로 이동
			response.sendRedirect(request.getContextPath()+"/");
			// 기존에 가려던 URL은 방문하지 않고 메인으로 이동
			return false; // (가려던 컨트롤러 갈필요없음)
		}
		// 로그인했으면 기존에 가려던 URL(페이지)를 방문해서 작업
		return true;
		
		// => url이 동작할 어쩌구를 지정해줘야함..... 
	}
}